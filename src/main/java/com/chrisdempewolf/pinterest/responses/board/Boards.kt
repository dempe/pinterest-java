package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

import java.util.Arrays

data class Boards(
        @SerializedName("data")val boards: List<Board>,
        @SerializedName("page") val nextPage: BoardPage?)