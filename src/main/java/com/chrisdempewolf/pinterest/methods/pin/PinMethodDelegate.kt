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

    fun getPin(id: String): PinResponse {
        try { return Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, null)), PinResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getPin(id: String, pinFields: PinFields): PinResponse {
        try { return Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, pinFields.build())), PinResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    /**
     * I adopted the true/false pattern for deletion from RestFB
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

    fun postPin(
            boardName: String,
            note: String,
            image: String,
            link: String? = null): ResponseMessageAndStatusCode {
        try {
            return NetworkHelper.submitPostRequest(
                    buildBasePinUri(accessToken),
                    buildPostMap(boardName, note, image, link))
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyPins(): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, null)), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyPins(pinFields: PinFields): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, pinFields.build())), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getPinsFromBoard(boardName: String): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, null)), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getPinsFromBoard(boardName: String, pinFields: PinFields): Pins {
        try { return Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, pinFields.build())), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getNextPageOfPins(page: PinPage?): Pins? {
        if (page == null || page.next == null) { return null }

        try { return Gson().fromJson(IOUtils.toString(URI(page.next)), Pins::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    private fun buildPostMap(boardName: String, note: String, image: String, link: String?): Map<String, String> {
        link?.let { return mapOf("board" to boardName, "note" to note, "image" to image, "link" to link) }
        return mapOf("board" to boardName, "note" to note, "image" to image)
    }
}
