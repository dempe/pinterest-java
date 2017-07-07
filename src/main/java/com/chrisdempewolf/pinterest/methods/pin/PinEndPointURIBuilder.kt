package com.chrisdempewolf.pinterest.methods.pin

import org.apache.http.client.utils.URIBuilder

import java.net.URI
import java.net.URISyntaxException
import java.util.regex.Pattern

import org.apache.commons.lang3.StringUtils.isNotBlank

object PinEndPointURIBuilder {
    private const val BASE_URL = "https://api.pinterest.com"
    private const val BOARD_PIN_PATH = "/v1/boards/{BOARD_NAME}/pins/"
    private const val BASE_PIN_PATH = "/v1/pins/"
    private const val PIN_PATH = BASE_PIN_PATH + "{PIN_ID}/"
    private const val MY_PIN_PATH = "/v1/me/pins/"
    private val PIN_PATTERN = Pattern.compile("\\{PIN_ID\\}")
    private val BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}")

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildBasePinUri(accessToken: String): URI
        = URIBuilder(BASE_URL).setPath(BASE_PIN_PATH).setParameter("access_token", accessToken).build()

    @JvmStatic
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

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildMyPinUri(accessToken: String, fields: String?): URI {
        val uriBuilder = URIBuilder(BASE_URL).setPath(MY_PIN_PATH).setParameter("access_token", accessToken)

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }

        return uriBuilder.build()
    }

    @JvmStatic
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
