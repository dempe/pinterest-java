package com.chrisdempewolf.pinterest.responses.pin

class Original(val url: String?, val width: Int, val height: Int) {

    override fun toString(): String {
        return "Original{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}'
    }

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Original

        if (url != other.url) return false
        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int{
        var result = url?.hashCode() ?: 0
        result = 31 * result + width
        result = 31 * result + height
        return result
    }
}