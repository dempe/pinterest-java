package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

class Pin(val id: String?, val counts: Counts?, val url: String?, val note: String?, val link: String?, val board: Board?, val creator: Creator?, @SerializedName("created_at")
val createdAt: String?, val color: String?, val attribution: Attribution?, @SerializedName("metadata")
          val metaData: MetaData?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val pin = o as Pin?

        if (if (id != null) id != pin!!.id else pin!!.id != null) return false
        if (if (counts != null) counts != pin.counts else pin.counts != null) return false
        if (if (url != null) url != pin.url else pin.url != null) return false
        if (if (note != null) note != pin.note else pin.note != null) return false
        if (if (link != null) link != pin.link else pin.link != null) return false
        if (if (board != null) board != pin.board else pin.board != null) return false
        if (if (creator != null) creator != pin.creator else pin.creator != null) return false
        if (if (createdAt != null) createdAt != pin.createdAt else pin.createdAt != null) return false
        if (if (color != null) color != pin.color else pin.color != null) return false
        if (if (attribution != null) attribution != pin.attribution else pin.attribution != null) return false
        return if (metaData != null) metaData == pin.metaData else pin.metaData == null

    }

    override fun hashCode(): Int {
        var result = if (id != null) id.hashCode() else 0
        result = 31 * result + if (counts != null) counts.hashCode() else 0
        result = 31 * result + if (url != null) url.hashCode() else 0
        result = 31 * result + if (note != null) note.hashCode() else 0
        result = 31 * result + if (link != null) link.hashCode() else 0
        result = 31 * result + if (board != null) board.hashCode() else 0
        result = 31 * result + if (creator != null) creator.hashCode() else 0
        result = 31 * result + if (createdAt != null) createdAt.hashCode() else 0
        result = 31 * result + if (color != null) color.hashCode() else 0
        result = 31 * result + if (attribution != null) attribution.hashCode() else 0
        result = 31 * result + if (metaData != null) metaData.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "Pin{" +
                "id='" + id + '\'' +
                ", counts=" + counts +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", link='" + link + '\'' +
                ", board=" + board +
                ", creator=" + creator +
                ", createdAt='" + createdAt + '\'' +
                ", color='" + color + '\'' +
                ", attribution=" + attribution +
                ", metaData=" + metaData +
                '}'
    }
}
