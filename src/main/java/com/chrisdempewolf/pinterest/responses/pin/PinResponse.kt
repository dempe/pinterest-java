package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

class PinResponse(@SerializedName("data")
                  val pin: Pin?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val pinResponse = o as PinResponse?

        return !if (pin != null) pin != pinResponse!!.pin else pinResponse!!.pin != null
    }

    override fun hashCode(): Int {
        return if (pin != null) pin.hashCode() else 0
    }

    override fun toString(): String {
        return "PinResponse{" +
                "pin=" + pin +
                '}'
    }
}
