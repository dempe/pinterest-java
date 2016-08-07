package com.chrisdempewolf.pinterest.fields.board

import com.chrisdempewolf.pinterest.fields.BaseFields

class BoardFields : BaseFields() {

    override fun setAll(): BoardFields {
        return this.setCounts().setCreatedAt().setDescription().setId().setImage().setName().setUrl()
    }

    fun setId(): BoardFields {
        fields = fields.plus("id")
        return this
    }

    fun setName(): BoardFields {
        fields = fields.plus("name")
        return this
    }

    fun setUrl(): BoardFields {
        fields = fields.plus("url")
        return this
    }

    fun setDescription(): BoardFields {
        fields = fields.plus("description")
        return this
    }

    fun setCreatedAt(): BoardFields {
        fields = fields.plus("created_at")
        return this
    }

    fun setCounts(): BoardFields {
        fields = fields.plus("counts")
        return this
    }

    fun setImage(): BoardFields {
        fields = fields.plus("image")
        return this
    }
}
