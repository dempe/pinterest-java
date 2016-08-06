package com.chrisdempewolf.pinterest.responses.pin

class PinPage(val cursor: String?, val next: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val page = o as PinPage?

        if (if (cursor != null) cursor != page!!.cursor else page!!.cursor != null) return false
        return !if (next != null) next != page.next else page.next != null

    }

    override fun hashCode(): Int {
        var result = if (cursor != null) cursor.hashCode() else 0
        result = 31 * result + if (next != null) next.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Page{" +
                "cursor='" + cursor + '\'' +
                ", next='" + next + '\'' +
                '}'
    }
}
