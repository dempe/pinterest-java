package com.chrisdempewolf.pinterest.responses

class SixtyBySixty(val url: String?, val width: String?, val height: String?) {

    override fun toString(): String {
        return "SixtyBySixty{" +
                "url='" + url + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}'
    }
}
