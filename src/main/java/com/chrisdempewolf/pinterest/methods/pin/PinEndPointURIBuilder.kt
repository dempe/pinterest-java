package com.chrisdempewolf.pinterest.methods.pin

import org.apache.http.client.utils.URIBuilder

import java.net.URI
import java.net.URISyntaxException
import java.util.regex.Pattern

import org.apache.commons.lang3.StringUtils.isNotBlank

class PinEndPointURIBuilder private constructor() {

    init {
        throw IllegalStateException("Instantiation not allowed")
    }

    companion object {
        private val BASE_URL = "https://api.pinterest.com"
        private val BOARD_PIN_PATH = "/v1/boards/{BOARD_NAME}/pins/"
        private val BASE_PIN_PATH = "/v1/pins"
        private val PIN_PATH = BASE_PIN_PATH + "/{PIN_ID}"
        private val MY_PIN_PATH = "/v1/me/pins/"
        private val PIN_PATTERN = Pattern.compile("\\{PIN_ID\\}")
        private val BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}")

        @Throws(URISyntaxException::class)
        fun buildBasePinUri(accessToken: String): URI {
            return URIBuilder(BASE_URL).setPath(BASE_PIN_PATH).setParameter("access_token", accessToken).build()
        }

        @Throws(URISyntaxException::class)
        fun buildPinUri(accessToken: String, id: String, fields: String?): URI {
            val uriBuilder = URIBuilder(BASE_URL)
                    .setPath(PIN_PATTERN.matcher(PIN_PATH).replaceFirst(id))
                    .setParameter("access_token", accessToken)

            if (isNotBlank(fields)) {
                uriBuilder.setParameter("fields", fields)
            }

            return uriBuilder.build()
        }

        @Throws(URISyntaxException::class)
        fun buildMyPinUri(accessToken: String, fields: String?): URI {
            val uriBuilder = URIBuilder(BASE_URL).setPath(MY_PIN_PATH).setParameter("access_token", accessToken)

            if (isNotBlank(fields)) {
                uriBuilder.setParameter("fields", fields)
            }

            return uriBuilder.build()
        }

        @Throws(URISyntaxException::class)
        fun buildBoardPinUri(accessToken: String, name: String, fields: String?): URI {
            val uriBuilder = URIBuilder(BASE_URL)
                    .setPath(BOARD_NAME_PATTERN.matcher(BOARD_PIN_PATH).replaceFirst(name))
                    .setParameter("access_token", accessToken)

            if (isNotBlank(fields)) {
                uriBuilder.setParameter("fields", fields)
            }

            return uriBuilder.build()
        }
    }
}
