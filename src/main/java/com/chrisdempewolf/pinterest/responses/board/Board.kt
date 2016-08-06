package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

data class Board(
        val description: String?,
        val url: String?,
        @SerializedName("created_at") val createdAt: String?,
        val id: String?,
        val name: String?,
        val counts: Counts?,
        val image: Image?)
