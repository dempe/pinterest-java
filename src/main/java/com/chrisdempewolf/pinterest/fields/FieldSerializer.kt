package com.chrisdempewolf.pinterest.fields

import java.util.regex.Pattern

object FieldSerializer {
    private val INVALID_CHAR_PATTERN = Pattern.compile("[\\[\\] ]")

    @JvmStatic
    fun serialize(fields: Set<String>?): String
        = if (fields == null) ""
          else INVALID_CHAR_PATTERN.matcher(fields.toString()).replaceAll("")

}
