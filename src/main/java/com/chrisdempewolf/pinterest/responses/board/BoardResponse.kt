package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

class BoardResponse(@SerializedName("data") val board: Board?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val boardResponse = o as BoardResponse?

        return !if (board != null) board != boardResponse!!.board else boardResponse!!.board != null

    }

    override fun hashCode(): Int {
        return if (board != null) board.hashCode() else 0
    }

    override fun toString(): String {
        return "BoardResponse{" +
                "board=" + board +
                '}'
    }
}
