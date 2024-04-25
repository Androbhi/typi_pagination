package com.android.typipagination.repository

import android.util.Log
import com.android.typipagination.data.cache.Memoizer
import com.android.typipagination.data.remote.apiservice.ApiService
import com.android.typipagination.data.remote.mapper.PostsMapper
import com.android.typipagination.entity.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

private const val TAG = "TypiCodeRepositoryImpl"
internal class TypiCodeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val memoizer: Memoizer
) : TypiCodeRepository {
    override suspend fun getPosts(start: Int, limit: Int): Result<List<Post>> {

        val response = apiService.getPosts(
            start = start,
            limit = limit
        )
        if (response.isSuccessful.not()) {
            return Result.failure(
                Throwable(
                    response.errorBody()?.string()
                )
            )
        }
        return withContext(Dispatchers.IO) {
            PostsMapper.map(
                response.body().orEmpty()
            )
        }
    }

    override suspend fun storePost(post: Post): Post? {
        var storedPost: Post? = null
        val timeTaken = measureTimeMillis{
            delay(500L) //Mocking the heavy running task
            storedPost = memoizer.storePost(
                id = post.id,
                post = post
            )
        }
        Log.d(TAG, "TIME TAKEN: for individual item calculation $timeTaken")
        return storedPost
    }
}