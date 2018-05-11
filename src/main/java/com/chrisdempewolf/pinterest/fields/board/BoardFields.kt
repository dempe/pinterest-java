package com.chrisdempewolf.pinterest.fields.board

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.pin.PinFields

class BoardFields : BaseFields() {

    override fun withAll(): BoardFields {
        return withCounts()
                .withCreatedAt()
                .withDescription()
                .withID()
                .withImage()
                .withName()
                .withURL()
    }

    fun withID(): BoardFields {
        fields = fields.plus("id")
        return this
    }

    fun withName(): BoardFields {
        fields = fields.plus("name")
        return this
    }

    fun withURL(): BoardFields {
        fields = fields.plus("url")
        return this
    }

    fun withDescription(): BoardFields {
        fields = fields.plus("description")
        return this
    }

    fun withCreatedAt(): BoardFields {
        fields = fields.plus("created_at")
        return this
    }

    fun withCounts(): BoardFields {
        fields = fields.plus("counts")
        return this
    }

    fun withImage(): BoardFields {
        fields = fields.plus("image")
        return this
    }

    fun with(field: String): BoardFields {
        fields = fields.plus(field)
        return this
    }
}
