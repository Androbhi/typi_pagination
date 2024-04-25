package com.android.typipagination.data.remote.apiservice

import com.android.typipagination.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(
        @Query("_start") start: Int,
        @Query("_limit") limit: Int,
    ): Response<List<PostDto>>

}