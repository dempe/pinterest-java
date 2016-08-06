package com.chrisdempewolf.pinterest.responses.board

import com.google.gson.annotations.SerializedName

class Board(
        val description: String?,
        val url: String?,
        @SerializedName("created_at") val createdAt: String?,
        val id: String?,
        val name: String?,
        val counts: Counts?,
        val image: Image?) {

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Board

        if (description != other.description) return false
        if (url != other.url) return false
        if (createdAt != other.createdAt) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (counts != other.counts) return false
        if (image != other.image) return false

        return true
    }

    override fun hashCode(): Int{
        var result = description?.hashCode() ?: 0
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (counts?.hashCode() ?: 0)
        result = 31 * result + (image?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Pin{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", counts=" + counts +
                ", image=" + image +
                '}'
    }
}
