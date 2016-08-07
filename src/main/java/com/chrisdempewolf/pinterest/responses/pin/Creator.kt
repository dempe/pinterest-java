package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class Creator(
        val url: String?,
        @SerializedName("first_name") val firstName: String?,
        @SerializedName("last_name") val lastName: String?,
        val id: String?)
