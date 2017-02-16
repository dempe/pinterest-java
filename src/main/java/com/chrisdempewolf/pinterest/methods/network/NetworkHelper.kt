package com.chrisdempewolf.pinterest.methods.network

import org.apache.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.fluent.Form
import org.apache.http.client.fluent.Request
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

import java.io.IOException
import java.net.URI

object NetworkHelper {

    @JvmStatic
    @Throws(IOException::class)
    fun submitDeleteRequest(url: URI): ResponseMessageAndStatusCode {
        val response = Request.Delete(url)
                .execute()
                .returnResponse()

        return convertResponse(response)
    }

    @JvmStatic
    fun submitPostRequest(url: URI, formData: Map<String, String>): ResponseMessageAndStatusCode {
        val response = Request.Post(url)
                .bodyForm(convertMapToForm(formData))
                .execute()
                .returnResponse()

        return convertResponse(response)
    }

    @JvmStatic
    private fun convertResponse(response: HttpResponse): ResponseMessageAndStatusCode {
        return ResponseMessageAndStatusCode(response.statusLine.statusCode, EntityUtils.toString(response.entity))
    }

    @JvmStatic
    private fun convertMapToForm(formData: Map<String, String>): List<NameValuePair> {
        val form = Form.form()
        formData.forEach { form.add(it.key, it.value) }
        return form.build()
    }
}
