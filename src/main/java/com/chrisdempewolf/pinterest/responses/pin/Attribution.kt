package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

class Attribution(val title: String?, val url: String?, @SerializedName("provider_icon_url")
val providerIconUrl: String?, @SerializedName("author_name")
                  val authorName: String?, @SerializedName("provider_favicon_url")
                  val providerFaviconUrl: String?, @SerializedName("author_url")
                  val authorUrl: String?, @SerializedName("provider_name")
                  val providerName: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as Attribution?

        if (if (title != null) title != that!!.title else that!!.title != null) return false
        if (if (url != null) url != that.url else that.url != null) return false
        if (if (providerIconUrl != null) providerIconUrl != that.providerIconUrl else that.providerIconUrl != null)
            return false
        if (if (authorName != null) authorName != that.authorName else that.authorName != null) return false
        if (if (providerFaviconUrl != null) providerFaviconUrl != that.providerFaviconUrl else that.providerFaviconUrl != null)
            return false
        if (if (authorUrl != null) authorUrl != that.authorUrl else that.authorUrl != null) return false
        return if (providerName != null) providerName == that.providerName else that.providerName == null

    }

    override fun hashCode(): Int {
        var result = if (title != null) title.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        result = 31 * result + if (providerIconUrl != null) providerIconUrl.hashCode() else 0
        result = 31 * result + if (authorName != null) authorName.hashCode() else 0
        result = 31 * result + if (providerFaviconUrl != null) providerFaviconUrl.hashCode() else 0
        result = 31 * result + if (authorUrl != null) authorUrl.hashCode() else 0
        result = 31 * result + if (providerName != null) providerName.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Attribution{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", providerIconUrl='" + providerIconUrl + '\'' +
                ", authorName='" + authorName + '\'' +
                ", providerFaviconUrl='" + providerFaviconUrl + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", providerName='" + providerName + '\'' +
                '}'
    }
}
