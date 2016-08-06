package com.chrisdempewolf.pinterest.responses.pin

class Counts(val likes: Int?, val comments: Int?, val repins: Int?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val counts = o as Counts?

        if (if (likes != null) likes != counts!!.likes else counts!!.likes != null) return false
        if (if (comments != null) comments != counts.comments else counts.comments != null) return false
        return !if (repins != null) repins != counts.repins else counts.repins != null

    }

    override fun hashCode(): Int {
        var result = if (likes != null) likes.hashCode() else 0
        result = 31 * result + if (comments != null) comments.hashCode() else 0
        result = 31 * result + if (repins != null) repins.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Counts{" +
                "likes=" + likes +
                ", comments=" + comments +
                ", repins=" + repins +
                '}'
    }
}
