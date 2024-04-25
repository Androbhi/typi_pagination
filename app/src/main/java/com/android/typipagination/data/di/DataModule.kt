package com.android.typipagination.data.di

import android.util.LruCache
import com.android.typipagination.data.cache.Memoizer
import com.android.typipagination.data.cache.MemoizerImpl
import com.android.typipagination.data.remote.interceptors.HeaderInterceptor
import com.android.typipagination.data.remote.interceptors.HeaderInterceptorImpl
import com.android.typipagination.entity.Post
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindsHeaderInformationInterceptor(
        headerInformationInterceptorImpl: HeaderInterceptorImpl
    ): HeaderInterceptor

    @Binds
    @Singleton
    internal abstract fun bindsMemoizer(
        memoizerImpl: MemoizerImpl
    ): Memoizer

    companion object {

        @Provides
        @Singleton
        fun providesLruCache(): LruCache<Int, Post> {
            val memoryCache: LruCache<Int, Post>
            val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
            val cacheSize = maxMemory / 8
            memoryCache = object : LruCache<Int, Post>(cacheSize) {
                override fun sizeOf(key: Int, post: Post): Int {
                    return cacheSize
                }
            }
            return memoryCache
        }

    }

}