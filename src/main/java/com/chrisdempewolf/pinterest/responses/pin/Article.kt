package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

import java.util.Arrays

data class Article(
        @SerializedName("published_at") val publishedAt: String?,
        val description: String?,
        val name: String?,
        val authors: List<Author>?)