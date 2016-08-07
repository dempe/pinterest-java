package com.chrisdempewolf.pinterest.fields

import java.util.regex.Pattern

object FieldSerializer {
    private val INVALID_CHAR_PATTERN = Pattern.compile("[\\[\\] ]")

    fun serialize(fields: Set<String>?): String {
        if (fields == null) { return "" }
        return INVALID_CHAR_PATTERN.matcher(fields.toString()).replaceAll("")
    }
}
