package com.android.typipagination.view.viewstate

import com.android.typipagination.entity.Post

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<Post?> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 0
)