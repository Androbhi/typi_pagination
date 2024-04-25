package com.android.typipagination.view.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}