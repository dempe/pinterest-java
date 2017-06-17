package com.chrisdempewolf.pinterest.fields.user

import com.chrisdempewolf.pinterest.fields.BaseFields
import com.chrisdempewolf.pinterest.fields.Fields

class UserFields : BaseFields() {
    override fun withAll(): UserFields {
        return withID()
                .withBio()
                .withCounts()
                .withCretedAt()
                .withFirstName()
                .withImage()
                .withLastName()
                .withURL()
                .withUsername()
    }

    fun withID(): UserFields {
        this.fields = fields.plus("id")
        return this
    }

    fun withUsername(): UserFields {
        this.fields = fields.plus("username")
        return this
    }

    fun withURL(): UserFields {
        this.fields = fields.plus("url")
        return this
    }

    fun withFirstName(): UserFields {
        this.fields = fields.plus("first_name")
        return this
    }

    fun withLastName(): UserFields {
        this.fields = fields.plus("last_name")
        return this
    }

    fun withBio(): UserFields {
        this.fields = fields.plus("bio")
        return this
    }

    fun withCretedAt(): UserFields {
        this.fields = fields.plus("created_at")
        return this
    }

    fun withCounts(): UserFields {
        this.fields = fields.plus("counts")
        return this
    }

    fun withImage(): UserFields {
        this.fields = fields.plus("image")
        return this
    }
}