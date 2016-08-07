package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class PinResponse(@SerializedName("data") val pin: Pin?)