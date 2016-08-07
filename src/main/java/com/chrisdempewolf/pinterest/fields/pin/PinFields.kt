package com.chrisdempewolf.pinterest.fields.pin

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.CreatorFields

import java.util.ArrayList

import com.chrisdempewolf.pinterest.fields.FieldSerializer.serialize
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

    // TODO:  is there a better way to do this? i.e., formulaically
    override fun setAll(): PinFields {
        this.setCounts().setLink().setMetadata().setNote().setUrl().setColor().setAttribution().setCreatedAt()
        creatorFields.setAll()
        boardPinFields.setAll()
        return this
    }

    fun setLink(): PinFields {
        fields = fields.plus("link")
        return this
    }

    fun setCounts(): PinFields {
        fields = fields.plus("counts")
        return this
    }

    fun setNote(): PinFields {
        fields = fields.plus("note")
        return this
    }

    fun setUrl(): PinFields {
        fields = fields.plus("url")
        return this
    }

    fun setMetadata(): PinFields {
        fields = fields.plus("metadata")
        return this
    }

    fun setColor(): PinFields {
        fields = fields.plus("color")
        return this
    }

    fun setAttribution(): PinFields {
        fields = fields.plus("attribution")
        return this
    }

    fun setCreatedAt(): PinFields {
        fields = fields.plus("created_at")
        return this
    }
}
