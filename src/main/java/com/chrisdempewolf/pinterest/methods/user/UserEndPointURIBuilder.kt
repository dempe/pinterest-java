package com.chrisdempewolf.pinterest.methods.user

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.StringUtils.isNotBlank
import org.apache.http.client.utils.URIBuilder
import java.net.URI
import java.net.URISyntaxException

object UserEndPointURIBuilder {
    private const val BASE_URL = "https://api.pinterest.com/v1/me/"

    @JvmStatic
    @Throws(URISyntaxException::class)
    fun buildURI(accessToken: String, fields: String? = null, path: String? = null, query: String? = null): URI {
        val uriBuilder = URIBuilder(BASE_URL).setParameter("access_token", accessToken)

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields)
        }
        if (isNotBlank(path)) {
            uriBuilder.setPath(uriBuilder.path + path)
        }
        if (isNotBlank(query)) {
            uriBuilder.setParameter("query", query)
        }

        return uriBuilder.build()
    }
}