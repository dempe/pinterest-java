package com.chrisdempewolf.pinterest.fields

class CreatorFields : BaseFields() {

    override fun withAll(): Fields {
        return this.setFirstName().setId().setLastName().setUrl()
    }

    fun setId(): CreatorFields {
        fields = fields.plus("id")
        return this
    }

    fun setFirstName(): CreatorFields {
        fields = fields.plus("first_name")
        return this
    }

    fun setLastName(): CreatorFields {
        fields = fields.plus("last_name")
        return this
    }

    fun setUrl(): CreatorFields {
        fields = fields.plus("url")
        return this
    }
}
