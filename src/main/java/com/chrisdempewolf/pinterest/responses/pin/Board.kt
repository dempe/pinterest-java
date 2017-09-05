package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class Board(val id: String?, val name: String?, val url: String?, @SerializedName("counts") val boardCounts: BoardCounts?)