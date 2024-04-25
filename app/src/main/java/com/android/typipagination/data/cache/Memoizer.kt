package com.android.typipagination.data.cache

import com.android.typipagination.entity.Post

interface Memoizer {

    suspend fun storePost(id: Int, post: Post): Post?

    suspend fun getPost(id: Int): Post?
}