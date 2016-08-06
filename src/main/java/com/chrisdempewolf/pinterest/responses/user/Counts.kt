package com.chrisdempewolf.pinterest.responses.user

class Counts(val pins: Int, val following: Int, val followers: Int, val boards: Int, val likes: Int) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val counts = o as Counts?

        if (pins != counts!!.pins) return false
        if (following != counts.following) return false
        if (followers != counts.followers) return false
        if (boards != counts.boards) return false
        return likes == counts.likes

    }

    override fun hashCode(): Int {
        var result = pins
        result = 31 * result + following
        result = 31 * result + followers
        result = 31 * result + boards
        result = 31 * result + likes
        return result
    }

    override fun toString(): String {
        return "Counts{" +
                "pins=" + pins +
                ", following=" + following +
                ", followers=" + followers +
                ", boards=" + boards +
                ", likes=" + likes +
                '}'
    }
}
