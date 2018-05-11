package com.chrisdempewolf.pinterest.fields

import java.util.HashSet

abstract class BaseFields : Fields {
    protected var fields: Set<String> = HashSet()

    override fun build(): String
        = FieldSerializer.serialize(fields)

    override fun toString(): String
        = build()
}
