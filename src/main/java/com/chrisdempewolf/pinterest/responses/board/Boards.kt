package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

import java.util.Arrays

class Boards(boards: Array<Board>, @SerializedName("page")
val nextPage: BoardPage?) {
    @SerializedName("data") val boards: List<Board>?

    init {
        this.boards = Arrays.asList(*boards)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val boards1 = o as Boards?

        if (if (boards != null) boards != boards1!!.boards else boards1!!.boards != null) return false
        return if (nextPage != null) nextPage == boards1.nextPage else boards1.nextPage == null

    }

    override fun hashCode(): Int {
        var result = if (boards != null) boards.hashCode() else 0
        result = 31 * result + if (nextPage != null) nextPage.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Boards{" +
                "boards=" + boards +
                ", page=" + nextPage +
                '}'
    }
}
