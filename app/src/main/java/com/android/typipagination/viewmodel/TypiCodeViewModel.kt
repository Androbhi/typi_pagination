package com.android.typipagination.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.typipagination.repository.TypiCodeRepository
import com.android.typipagination.view.pagination.DefaultPaginator
import com.android.typipagination.view.viewstate.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.system.measureTimeMillis

private const val TAG = "TypiCodeViewModel"

@HiltViewModel
class TypiCodeViewModel @Inject constructor(
    private val repository: TypiCodeRepository,
) : ViewModel() {

    var state by mutableStateOf(ScreenState())

    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->

            repository.getPosts(nextPage, 20)
        },
        getNextKey = {
            state.page + it.size
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            supervisorScope {
                val timeTaken = measureTimeMillis {
                    val posts = items.map { post ->
                        async {
                            repository.storePost(
                                post
                            )
                        }
                    }.awaitAll()

                    state = state.copy(
                        items = state.items + posts,
                        page = newKey,
                        endReached = items.isEmpty()
                    )
                }
                Log.d(TAG, "TIME TAKEN: for all paginated items calculation $timeTaken")
            }
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            try {
                paginator.loadNextItems()
            } catch (e: Exception) {
                state = state.copy(
                    error = when (e) {
                        is UnknownHostException -> {
                            "No Internet"
                        }

                        else -> {
                            "Some thing went wrong"
                        }
                    }
                )
            }

        }
    }

}