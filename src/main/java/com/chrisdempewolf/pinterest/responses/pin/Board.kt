package com.chrisdempewolf.pinterest.responses.pin

class Board(val id: String?, val name: String?, val url: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val board = o as Board?

        if (if (id != null) id != board!!.id else board!!.id != null) return false
        if (if (name != null) name != board.name else board.name != null) return false
        return !if (url != null) url != board.url else board.url != null

    }

    override fun hashCode(): Int {
        var result = if (id != null) id.hashCode() else 0
        result = 31 * result + if (name != null) name.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "BoardResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}'
    }
}
