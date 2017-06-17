package com.chrisdempewolf.pinterest.fields

class CreatorFields : BaseFields() {

    override fun withAll(): Fields {
        return withFirstName()
                .withID()
                .withLastName()
                .withURL()
    }

    fun withID(): CreatorFields {
        fields = fields.plus("id")
        return this
    }

    fun withFirstName(): CreatorFields {
        fields = fields.plus("first_name")
        return this
    }

    fun withLastName(): CreatorFields {
        fields = fields.plus("last_name")
        return this
    }

    fun withURL(): CreatorFields {
        fields = fields.plus("url")
        return this
    }
}
