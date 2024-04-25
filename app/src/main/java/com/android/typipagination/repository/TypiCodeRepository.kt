package com.android.typipagination.repository

import com.android.typipagination.entity.Post

interface TypiCodeRepository {
    suspend fun getPosts(
        start: Int,
        limit: Int
    ): Result<List<Post>>

    suspend fun storePost(post: Post): Post?
}