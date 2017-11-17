package com.chrisdempewolf.pinterest.responses.board

import com.chrisdempewolf.pinterest.responses.pin.Pin
import com.google.gson.annotations.SerializedName

import java.util.Arrays

data class Boards(@SerializedName("data") val boards: List<Board>,
                  @SerializedName("page") val nextPage: BoardPage?) : Iterable<Board> {

    override fun iterator(): Iterator<Board>
            = boards.iterator()
}