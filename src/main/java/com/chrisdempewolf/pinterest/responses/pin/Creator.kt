package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

class Creator(val url: String?, @SerializedName("first_name")
val firstName: String?, @SerializedName("last_name")
              val lastName: String?, val id: String?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val creator = o as Creator?

        if (if (url != null) url != creator!!.url else creator!!.url != null) return false
        if (if (firstName != null) firstName != creator.firstName else creator.firstName != null) return false
        if (if (lastName != null) lastName != creator.lastName else creator.lastName != null) return false
        return !if (id != null) id != creator.id else creator.id != null

    }

    override fun hashCode(): Int {
        var result = if (url != null) url.hashCode() else 0
        result = 31 * result + if (firstName != null) firstName.hashCode() else 0
        result = 31 * result + if (lastName != null) lastName.hashCode() else 0
        result = 31 * result + if (id != null) id.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Creator{" +
                "url='" + url + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}'
    }
}
