package com.chrisdempewolf.pinterest.fields.pin

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.Fields

class BoardPinFields : BaseFields() {

    override fun withAll(): Fields {
        return this.withID().withName().withURL()
    }

    fun withID(): BoardPinFields {
        fields = fields.plus("id")
        return this
    }

    fun withName(): BoardPinFields {
        fields = fields.plus("name")
        return this
    }

    fun withURL(): BoardPinFields {
        fields = fields.plus("url")
        return this
    }
}
