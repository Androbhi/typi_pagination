package com.android.typipagination.data.remote.mapper

interface Mapper<in I, out O> {
    suspend fun map(input: I): O
}