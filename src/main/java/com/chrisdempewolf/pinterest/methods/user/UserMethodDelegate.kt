package com.chrisdempewolf.pinterest.methods.user

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.fields.user.UserFields
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.chrisdempewolf.pinterest.responses.user.User
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.net.URISyntaxException

class UserMethodDelegate(private val accessToken: String) {

    fun getUser(userFields: UserFields? = null): User {
        try {
            val response = IOUtils.toString(UserEndPointURIBuilder.buildURI(accessToken, userFields?.build()))
            return Gson().fromJson(response, User::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getSuggestedBoards(boardFields: BoardFields? = null): Boards {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, boardFields?.build(), "boards/suggested/")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Boards::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }
}