package com.chrisdempewolf.pinterest.methods.pin

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.pin.PinFields
import com.chrisdempewolf.pinterest.methods.network.NetworkHelper
import com.chrisdempewolf.pinterest.methods.network.ResponseMessageAndStatusCode
import com.chrisdempewolf.pinterest.methods.pin.PinEndPointURIBuilder.buildBasePinUri
import com.chrisdempewolf.pinterest.methods.pin.PinEndPointURIBuilder.buildBoardPinUri
import com.chrisdempewolf.pinterest.methods.pin.PinEndPointURIBuilder.buildMyPinUri
import com.chrisdempewolf.pinterest.methods.pin.PinEndPointURIBuilder.buildPinUri
import com.chrisdempewolf.pinterest.responses.pin.PinPage
import com.chrisdempewolf.pinterest.responses.pin.PinResponse
import com.chrisdempewolf.pinterest.responses.pin.Pins
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import org.apache.http.HttpStatus
import org.apache.http.client.fluent.Form
import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.fluent.Request

import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

class PinMethodDelegate(private val accessToken: String) {

    fun getPin(id: String, pinFields: PinFields): PinResponse {
        try { return Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, pinFields.build())), PinResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    /**
     * This true/false pattern for deletion was adopted from RestFB: http://restfb.com/
     * @param id:  Pin ID
     * @return true iff deletion was successful
     */
    fun deletePin(id: String): Boolean {
        try {
            val response = NetworkHelper.submitDeleteRequest(buildPinUri(accessToken, id, null))
            return response.statusCode == HttpStatus.SC_OK
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun patchPin(pinID: String, board: String?, note: String?, link: String?): ResponseMessageAndStatusCode {
        try {
            val patchBodyMap: Map<String, String?> = mapOf(
                    "board" to board,
                    "note" to note,
                    "link" to link)

            return NetworkHelper.submitPatchRequest(
                    buildPinUri(accessToken, pinID, null),
                    buildNonNullMap(patchBodyMap))
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun postPin(
            boardName: String,
            note: String,
            image: String,
            link: String? = null): ResponseMessageAndStatusCode {
        try {
            val postBodyMap: Map<String, String?> = mapOf(
                    "board" to boardName,
                    "note" to note,
                    "image_url" to image,
                    "link" to link)

            return NetworkHelper.submitPostRequest(
                    buildBasePinUri(accessToken),
                    buildNonNullMap(postBodyMap))
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyPins(pinFields: PinFields? = null): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, pinFields?.build())), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getPinsFromBoard(boardName: String, pinFields: PinFields? = null): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, pinFields?.build())), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getNextPageOfPins(page: PinPage?): Pins? {
        if (page == null || page.next == null) { return null }

        try { return Gson().fromJson(IOUtils.toString(URI(page.next)), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    /**
     * Takes a Map<String, String?> and filters any null or blank values to use for POST and PATCH bodies.
     */
    private fun buildNonNullMap(map: Map<String, String?>): Map<String, String>
        = map.filter { e -> !e.value.isNullOrBlank() } as Map<String, String>

}
