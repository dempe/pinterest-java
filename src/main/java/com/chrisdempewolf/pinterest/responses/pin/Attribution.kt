package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

data class Attribution(
        val title: String?,
        val url: String?,
        @SerializedName("provider_icon_url") val providerIconUrl: String?,
        @SerializedName("author_name") val authorName: String?,
        @SerializedName("provider_favicon_url") val providerFaviconUrl: String?,
        @SerializedName("author_url") val authorUrl: String?,
        @SerializedName("provider_name") val providerName: String?)