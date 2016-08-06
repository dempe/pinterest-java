package com.chrisdempewolf.pinterest.responses.pin

class Media(val type: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val media = o as Media?

        return !if (type != null) type != media!!.type else media!!.type != null

    }

    override fun hashCode(): Int {
        return if (type != null) type.hashCode() else 0
    }

    override fun toString(): String {
        return "Media{" +
                "type='" + type + '\'' +
                '}'
    }
}
