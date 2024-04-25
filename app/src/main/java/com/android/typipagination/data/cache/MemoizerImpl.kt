package com.android.typipagination.data.cache

import android.util.LruCache
import com.android.typipagination.entity.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class MemoizerImpl @Inject constructor(
    private val lruCache: LruCache<Int, Post>
) : Memoizer {


    override suspend fun storePost(id: Int, post: Post): Post? {
        return withContext(Dispatchers.IO) {
            if (lruCache.get(id) == null) {
                lruCache.put(id, post)
            }
            lruCache.get(id)
        }
    }

    override suspend fun getPost(id: Int): Post? {
        return withContext(Dispatchers.IO) {
            lruCache.get(id)
        }
    }

}