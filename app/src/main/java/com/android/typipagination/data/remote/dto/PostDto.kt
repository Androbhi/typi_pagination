package com.android.typipagination.data.remote.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class PostDto(
    @SerializedName("body")
    @Expose
    val body: String?,
    @SerializedName("id")
    @Expose
    val id: Int?,
    @SerializedName("title")
    @Expose
    val title: String?,
    @SerializedName("userId")
    @Expose
    val userId: Int?
)