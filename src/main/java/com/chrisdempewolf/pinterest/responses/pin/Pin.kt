package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class Pin(
        val id: String?,
        val counts: Counts?,
        val url: String?,
        val note: String?,
        val link: String?,
        val board: Board?,
        val creator: Creator?,
        @SerializedName("created_at") val createdAt: String?,
        val color: String?,
        val attribution: Attribution?,
        @SerializedName("metadata") val metaData: MetaData?)