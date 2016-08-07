package com.chrisdempewolf.pinterest.fields.pin

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.Fields

class BoardPinFields : BaseFields() {

    override fun setAll(): Fields {
        return this.setId().setName().setUrl()
    }

    fun setId(): BoardPinFields {
        fields = fields.plus("id")
        return this
    }

    fun setName(): BoardPinFields {
        fields = fields.plus("name")
        return this
    }

    fun setUrl(): BoardPinFields {
        fields = fields.plus("url")
        return this
    }
}
