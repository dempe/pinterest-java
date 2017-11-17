package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

import java.util.Arrays

data class Pins(@SerializedName("data") val pins: List<Pin>,
                @SerializedName("page") val nextPage: PinPage?) : Iterable<Pin> {

    override fun iterator(): Iterator<Pin>
        = pins.iterator()
}