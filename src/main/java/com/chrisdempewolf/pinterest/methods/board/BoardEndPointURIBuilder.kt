package com.chrisdempewolf.pinterest.methods.board

import org.apache.http.client.utils.URIBuilder

import java.net.URI
import java.net.URISyntaxException
import java.util.regex.Pattern

import org.apache.commons.lang3.StringUtils.isNotBlank

class BoardEndPointURIBuilder private constructor() {

    init {
        throw IllegalStateException("Instantiation not allowed")
    }

    companion object {
        private val BASE_URL = "https://api.pinterest.com"
        private val BOARD_PATH = "/v1/boards/{BOARD_NAME}/"
        private val MY_BOARD_PATH = "/v1/me/boards/"

        private val BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}")

        @Throws(URISyntaxException::class)
        fun buildBoardUri(accessToken: String, boardName: String, fields: String?): URI {
            val uriBuilder = URIBuilder(BASE_URL).setPath(BOARD_NAME_PATTERN.matcher(BOARD_PATH).replaceFirst(boardName)).setParameter("access_token", accessToken)

            if (isNotBlank(fields)) {
                uriBuilder.setParameter("fields", fields)
            }

            return uriBuilder.build()
        }

        @Throws(URISyntaxException::class)
        fun buildMyBoardUri(accessToken: String, fields: String?): URI {
            val uriBuilder = URIBuilder(BASE_URL).setPath(MY_BOARD_PATH).setParameter("access_token", accessToken)

            if (isNotBlank(fields)) {
                uriBuilder.setParameter("fields", fields)
            }

            return uriBuilder.build()
        }
    }
}
