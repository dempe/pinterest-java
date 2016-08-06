package com.chrisdempewolf.pinterest.responses.pin

class Image(val original: Original?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val image = o as Image?

        return !if (original != null) original != image!!.original else image!!.original != null

    }

    override fun hashCode(): Int{
        return original?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Image{" +
                "original=" + original +
                '}'
    }
}
