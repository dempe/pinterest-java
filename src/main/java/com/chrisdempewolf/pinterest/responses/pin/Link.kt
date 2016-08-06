package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

class Link(val locale: String?, val title: String?, @SerializedName("site_name")
val siteName: String?, val description: String?, val favicon: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val link = o as Link?

        if (if (locale != null) locale != link!!.locale else link!!.locale != null) return false
        if (if (title != null) title != link.title else link.title != null) return false
        if (if (siteName != null) siteName != link.siteName else link.siteName != null) return false
        if (if (description != null) description != link.description else link.description != null) return false
        return !if (favicon != null) favicon != link.favicon else link.favicon != null
    }

    override fun hashCode(): Int {
        var result = if (locale != null) locale.hashCode() else 0
        result = 31 * result + if (title != null) title.hashCode() else 0
        result = 31 * result + if (siteName != null) siteName.hashCode() else 0
        result = 31 * result + if (description != null) description.hashCode() else 0
        result = 31 * result + if (favicon != null) favicon.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Link{" +
                "locale='" + locale + '\'' +
                ", title='" + title + '\'' +
                ", siteName='" + siteName + '\'' +
                ", description='" + description + '\'' +
                ", favicon='" + favicon + '\'' +
                '}'
    }
}
