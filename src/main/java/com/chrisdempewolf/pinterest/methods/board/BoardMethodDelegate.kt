package com.chrisdempewolf.pinterest.methods.board

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.methods.network.NetworkHelper
import com.chrisdempewolf.pinterest.methods.network.ResponseMessageAndStatusCode
import com.chrisdempewolf.pinterest.responses.board.BoardPage
import com.chrisdempewolf.pinterest.responses.board.BoardResponse
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import org.apache.http.HttpStatus

import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

class BoardMethodDelegate(private val accessToken: String) {

    fun getBoard(boardName: String, boardFields: BoardFields? = null): BoardResponse {
        try { return Gson().fromJson(IOUtils.toString(BoardEndPointURIBuilder.buildBoardURI(accessToken, boardName, boardFields?.build())), BoardResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    /**
     * I adopted the true/false pattern for deletion from RestFB
     * @param id:  Pin ID
     * @return true iff deletion was successful
     */
    fun deleteBoard(boardName: String): Boolean {
        try {
            val response = NetworkHelper.submitDeleteRequest(BoardEndPointURIBuilder.buildBoardURI(accessToken, boardName, null))
            return response.statusCode == HttpStatus.SC_OK
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun postBoard(boardName: String, description: String): ResponseMessageAndStatusCode {
        try {
            return NetworkHelper.submitPostRequest(BoardEndPointURIBuilder.buildBaseBoardURI(accessToken, "description,id,name,url"),
                                                   mapOf("name" to boardName, "description" to description))
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    /**
     * In the patch request, both params are optional.  The default is simply a noop.
     * @param boardName:  the <username>/<actual-boardname> combo (e.g., "cdatarank/foo")
     * @param name:  the new name for the board (e.g., "foobar")
     * @param description: simply a string
     * @return ResponseMessageAndStatusCode
     */
    fun patchBoard(boardName: String,
                   name: String? = null,
                   description: String? = null): ResponseMessageAndStatusCode {
        try {
            return NetworkHelper.submitPatchRequest(BoardEndPointURIBuilder.buildBoardURI(accessToken, boardName, "description,id,name,url"),
                                                    mapOf("name" to name, "description" to description))
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyBoards(boardFields: BoardFields? = null): Boards {
        try { return Gson().fromJson(IOUtils.toString(BoardEndPointURIBuilder.buildMyBoardURI(accessToken, boardFields?.build())), Boards::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getNextPageOfBoards(page: BoardPage?): Boards? {
        if (page?.next == null) { return null }

        try { return Gson().fromJson(IOUtils.toString(URI(page.next)), Boards::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }
}
