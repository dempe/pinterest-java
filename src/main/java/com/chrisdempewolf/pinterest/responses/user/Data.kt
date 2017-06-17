package com.chrisdempewolf.pinterest.responses.user

import com.google.gson.annotations.SerializedName

data class Data(
        val username: String?,
        val bio: String?,
        @SerializedName("first_name") val firstName: String?,
        @SerializedName("last_name") val lastName: String?,
        val url: String?,
        @SerializedName("created_at") val createdAt: String?,
        val id: String?,
        val counts: Counts?,
        val image: Image?)
