package com.chrisdempewolf.pinterest.fields.pin

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.CreatorFields

import java.util.ArrayList

import com.chrisdempewolf.pinterest.fields.FieldSerializer.serialize
import com.chrisdempewolf.pinterest.fields.Fields
import org.apache.commons.lang3.StringUtils.isNotBlank
import org.apache.commons.lang3.StringUtils.join

class PinFields : BaseFields() {
    val creatorFields = CreatorFields()
    val boardPinFields = BoardPinFields()

    override fun build(): String {
        val serializedCreatorFields = creatorFields.build()
        val serializedBoardFields = boardPinFields.build()
        val serializedPinFields = serialize(fields)
        val serializedFieldsList = ArrayList<String>()

        if (isNotBlank(serializedCreatorFields)) {
            serializedFieldsList.add("creator($serializedCreatorFields)")
        }
        if (isNotBlank(serializedBoardFields)) {
            serializedFieldsList.add("board($serializedBoardFields)")
        }
        if (isNotBlank(serializedPinFields)) {
            serializedFieldsList.add(serializedPinFields)
        }

        return join(serializedFieldsList, ",")
    }

    override fun withAll(): PinFields {
        withCounts()
                .withLink()
                .withMetadata()
                .withNote()
                .withURL()
                .withColor()
                .withAttribution()
                .withCreatedAt()
        creatorFields.withAll()
        boardPinFields.withAll()
        return this
    }

    fun withLink(): PinFields {
        fields = fields.plus("link")
        return this
    }

    fun withCounts(): PinFields {
        fields = fields.plus("counts")
        return this
    }

    fun withNote(): PinFields {
        fields = fields.plus("note")
        return this
    }

    fun withURL(): PinFields {
        fields = fields.plus("url")
        return this
    }

    fun withMetadata(): PinFields {
        fields = fields.plus("metadata")
        return this
    }

    fun withColor(): PinFields {
        fields = fields.plus("color")
        return this
    }

    fun withAttribution(): PinFields {
        fields = fields.plus("attribution")
        return this
    }

    fun withCreatedAt(): PinFields {
        fields = fields.plus("created_at")
        return this
    }

    fun with(field: String): PinFields {
        fields = fields.plus(field)
        return this
    }
}
