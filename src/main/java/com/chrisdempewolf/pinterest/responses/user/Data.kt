package com.chrisdempewolf.pinterest.responses.user

import com.google.gson.annotations.SerializedName

class Data(
        val username: String?,
        val bio: String?,
        @SerializedName("first_name") val firstName: String?,
        @SerializedName("last_name") val lastName: String?,
        val url: String?,
        @SerializedName("created_at") val createdAt: String?,
        val id: String?,
        val counts: Counts?,
        val image: Image?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val data = o as Data?

        if (if (username != null) username != data!!.username else data!!.username != null) return false
        if (if (bio != null) bio != data.bio else data.bio != null) return false
        if (if (firstName != null) firstName != data.firstName else data.firstName != null) return false
        if (if (lastName != null) lastName != data.lastName else data.lastName != null) return false
        if (if (url != null) url != data.url else data.url != null) return false
        if (if (createdAt != null) createdAt != data.createdAt else data.createdAt != null) return false
        if (if (id != null) id != data.id else data.id != null) return false
        if (if (counts != null) counts != data.counts else data.counts != null) return false
        return !if (image != null) image != data.image else data.image != null

    }

    override fun hashCode(): Int {
        var result = if (username != null) username.hashCode() else 0
        result = 31 * result + if (bio != null) bio.hashCode() else 0
        result = 31 * result + if (firstName != null) firstName.hashCode() else 0
        result = 31 * result + if (lastName != null) lastName.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        result = 31 * result + if (createdAt != null) createdAt.hashCode() else 0
        result = 31 * result + if (id != null) id.hashCode() else 0
        result = 31 * result + if (counts != null) counts.hashCode() else 0
        result = 31 * result + if (image != null) image.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Pin{" +
                "username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", counts=" + counts +
                ", image=" + image +
                '}'
    }
}
