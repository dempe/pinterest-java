package com.chrisdempewolf.pinterest.methods.board

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.Companion.buildBoardUri
import com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.Companion.buildMyBoardUri
import com.chrisdempewolf.pinterest.responses.board.BoardPage
import com.chrisdempewolf.pinterest.responses.board.BoardResponse
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.google.gson.Gson
import org.apache.commons.io.IOUtils

import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

class BoardMethodDelegate(private val accessToken: String) {

    fun getBoard(boardName: String): BoardResponse {
        try { return Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, null)), BoardResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getBoard(boardName: String, boardFields: BoardFields): BoardResponse {
        try { return Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, boardFields.build())), BoardResponse::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyBoards(): Boards {
        try { return Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, null)), Boards::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getMyBoards(boardFields: BoardFields): Boards {
        try { return Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, boardFields.build())), Boards::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getNextPageOfBoards(page: BoardPage?): Boards? {
        if (page == null || page.next == null) { return null }

        try { return Gson().fromJson(IOUtils.toString(URI(page.next)), Boards::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }
}
