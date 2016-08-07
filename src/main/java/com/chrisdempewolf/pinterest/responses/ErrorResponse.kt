package com.chrisdempewolf.pinterest.responses

import com.google.gson.annotations.SerializedName
import com.chrisdempewolf.pinterest.responses.pin.Pin

data class ErrorResponse(
        val status: String?,
        val code: Int,
        val host: String?,
        @SerializedName("generated_at") val generatedAt: String?,
        val message: String?,
        val data: Pin?)
