package com.chrisdempewolf.pinterest.methods.user

import com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder
import org.apache.commons.lang3.StringUtils
import org.apache.http.client.utils.URIBuilder
import java.net.URI
import java.net.URISyntaxException

object UserEndPointURIBuilder {
    private const val BASE_URL = "https://api.pinterest.com/v1/me/"

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildBaseURI(accessToken: String, fields: String?): URI {
        val uriBuilder = URIBuilder(BASE_URL).setParameter("access_token", accessToken)

        if (StringUtils.isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }

        return uriBuilder.build()
    }
}