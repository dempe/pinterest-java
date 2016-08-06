package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

import java.util.Arrays

class Pins(pins: Array<Pin>, @SerializedName("page")
val nextPage: PinPage?) : Iterable<Pin> {
    @SerializedName("data")
    val pins: List<Pin>?

    init {
        this.pins = Arrays.asList(*pins)
    }

    override fun iterator(): Iterator<Pin> {
        return pins!!.iterator()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val pins1 = o as Pins?

        if (if (pins != null) pins != pins1!!.pins else pins1!!.pins != null) return false
        return !if (nextPage != null) nextPage != pins1.nextPage else pins1.nextPage != null

    }

    override fun hashCode(): Int {
        var result = if (pins != null) pins.hashCode() else 0
        result = 31 * result + if (nextPage != null) nextPage.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Pins{" +
                "pins=" + pins +
                ", page=" + nextPage +
                '}'
    }
}
