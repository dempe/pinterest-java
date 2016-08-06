package com.chrisdempewolf.pinterest.responses.board

class Counts(val pins: Int, val collaborators: Int, val followers: Int) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val counts = o as Counts?

        if (pins != counts!!.pins) return false
        if (collaborators != counts.collaborators) return false
        return followers == counts.followers

    }

    override fun hashCode(): Int {
        var result = pins
        result = 31 * result + collaborators
        result = 31 * result + followers
        return result
    }

    override fun toString(): String {
        return "Counts{" +
                "pins=" + pins +
                ", collaborators=" + collaborators +
                ", followers=" + followers +
                '}'
    }
}
