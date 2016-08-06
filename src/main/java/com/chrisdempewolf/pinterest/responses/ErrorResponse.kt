package com.chrisdempewolf.pinterest.responses

import com.google.gson.annotations.SerializedName
import com.chrisdempewolf.pinterest.responses.pin.Pin

class ErrorResponse(
        val status: String?,
        val code: Int,
        val host: String?,
        @SerializedName("generated_at") val generatedAt: String?,
        val message: String?,
        val data: Pin?) {

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as ErrorResponse

        if (status != other.status) return false
        if (code != other.code) return false
        if (host != other.host) return false
        if (generatedAt != other.generatedAt) return false
        if (message != other.message) return false
        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int{
        var result = status?.hashCode() ?: 0
        result = 31 * result + code
        result = 31 * result + (host?.hashCode() ?: 0)
        result = 31 * result + (generatedAt?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ErrorResponse{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", host='" + host + '\'' +
                ", generatedAt='" + generatedAt + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }
}
