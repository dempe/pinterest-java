package com.chrisdempewolf.pinterest.methods.network

import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

import java.io.IOException

object NetworkHelper {

    @Throws(IOException::class)
    fun submitDeleteRequest(httpDelete: HttpDelete): ResponseMessageAndStatusCode {
        return submitRequest(httpDelete)
    }

    @Throws(IOException::class)
    fun submitPostRequest(httpPost: HttpPost): ResponseMessageAndStatusCode {
        return submitRequest(httpPost)
    }

    @Throws(IOException::class)
    private fun submitRequest(httpRequestBase: HttpRequestBase): ResponseMessageAndStatusCode {
        HttpClients.createDefault().execute(httpRequestBase).use { response ->
            val responseBody = EntityUtils.toString(response.entity)
            val statusCode = response.statusLine.statusCode

            return ResponseMessageAndStatusCode(statusCode, responseBody)
        }
    }
}
