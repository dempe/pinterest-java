package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class Link(
        val locale: String?,
        val title: String?,
        @SerializedName("site_name") val siteName: String?,
        val description: String?,
        val favicon: String?)