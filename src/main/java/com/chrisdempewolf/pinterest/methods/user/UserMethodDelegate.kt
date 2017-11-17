package com.chrisdempewolf.pinterest.methods.user

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.fields.pin.PinFields
import com.chrisdempewolf.pinterest.fields.user.UserFields
import com.chrisdempewolf.pinterest.responses.board.BoardPage
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.chrisdempewolf.pinterest.responses.pin.Pins
import com.chrisdempewolf.pinterest.responses.user.User
import com.chrisdempewolf.pinterest.responses.user.UserPage
import com.chrisdempewolf.pinterest.responses.user.Users
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.net.URI
import java.net.URISyntaxException

class UserMethodDelegate(private val accessToken: String) {

    fun get(userFields: UserFields? = null): User {
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

    fun getBoards(boardFields: BoardFields? = null): Boards {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, boardFields?.build(), "boards/")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Boards::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getPins(pinFields: PinFields? = null): Pins {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, pinFields?.build(), "pins/")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Pins::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getFollowers(userFields: UserFields? = null): Users {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, userFields?.build(), "followers/")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Users::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun searchBoards(query: String, boardFields: BoardFields? = null): Boards {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, boardFields?.build(), "search/boards", query)
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Boards::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun searchPins(query: String, pinFields: PinFields? = null): Pins {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, pinFields?.build(), "search/pins", query)
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Pins::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getFollowersBoards(boardFields: BoardFields? = null): Boards {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, boardFields?.build(), "following/boards")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Boards::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getFollowing(userFields: UserFields? = null): Users {
        try {
            val uri = UserEndPointURIBuilder.buildURI(accessToken, userFields?.build(), "following/users")
            val response = IOUtils.toString(uri)
            return Gson().fromJson(response, Users::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }

    fun getNextPageOfUsers(page: UserPage?): Users? {
        if (page?.next == null) { return null }

        try { return Gson().fromJson(IOUtils.toString(URI(page.next)), Users::class.java) }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }
}