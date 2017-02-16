package com.chrisdempewolf.pinterest.methods.board

import org.apache.http.client.utils.URIBuilder

import java.net.URI
import java.net.URISyntaxException
import java.util.regex.Pattern

import org.apache.commons.lang3.StringUtils.isNotBlank

object BoardEndPointURIBuilder {
    private const val BASE_URL = "https://api.pinterest.com"
    private const val BASE_BOARD_PATH = "/v1/boards/"
    private const val BOARD_PATH = "$BASE_BOARD_PATH{BOARD_NAME}/"
    private const val MY_BOARD_PATH = "/v1/me/boards/"

    private val BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}")

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildBaseBoardUri(accessToken: String, fields: String?): URI {
        val uriBuilder = URIBuilder(BASE_URL).setPath(BASE_BOARD_PATH).setParameter("access_token", accessToken)

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }

        return uriBuilder.build()
    }

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildBoardUri(accessToken: String, boardName: String, fields: String?): URI {
        val uriBuilder = URIBuilder(BASE_URL).setPath(BOARD_NAME_PATTERN.matcher(BOARD_PATH).replaceFirst(boardName)).setParameter("access_token", accessToken)

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }

        return uriBuilder.build()
    }

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildMyBoardUri(accessToken: String, fields: String?): URI {
        val uriBuilder = URIBuilder(BASE_URL).setPath(MY_BOARD_PATH).setParameter("access_token", accessToken)

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }

        return uriBuilder.build()
    }

}
