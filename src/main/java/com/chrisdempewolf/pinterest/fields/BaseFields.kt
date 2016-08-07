package com.chrisdempewolf.pinterest.fields

import java.util.HashSet

abstract class BaseFields : Fields {
    protected var fields: Set<String> = HashSet()

    override fun build(): String {
        return FieldSerializer.serialize(fields)
    }

    override fun toString(): String {
        return build()
    }
}
