package com.chrisdempewolf.pinterest.responses.user

import com.google.gson.annotations.SerializedName
import com.chrisdempewolf.pinterest.responses.SixtyBySixty

class Image(@SerializedName("60x60") val sixtyBySixty: SixtyBySixty?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val image = o as Image?

        return !if (sixtyBySixty != null) sixtyBySixty != image!!.sixtyBySixty else image!!.sixtyBySixty != null

    }

    override fun hashCode(): Int {
        return if (sixtyBySixty != null) sixtyBySixty.hashCode() else 0
    }

    override fun toString(): String {
        return "Image{" +
                "sixtyBySixty=" + sixtyBySixty +
                '}'
    }
}
