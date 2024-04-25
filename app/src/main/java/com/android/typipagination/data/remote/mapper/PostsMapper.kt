package com.android.typipagination.data.remote.mapper

import com.android.typipagination.data.remote.dto.PostDto
import com.android.typipagination.entity.Post

object PostsMapper : Mapper<List<PostDto>, Result<List<Post>>> {
    override suspend fun map(input: List<PostDto>): Result<List<Post>> {
        return runCatching {
            input.map { postDto ->
                postDto.run {
                    Post(
                        id = id ?: Int.MAX_VALUE,
                        title = title.orEmpty(),
                        body = body.orEmpty()
                    )
                }
            }
        }
    }
}