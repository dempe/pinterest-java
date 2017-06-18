package com.chrisdempewolf.pinterest.methods.user

import com.chrisdempewolf.pinterest.exceptions.PinterestException
import com.chrisdempewolf.pinterest.fields.user.UserFields
import com.chrisdempewolf.pinterest.methods.pin.PinEndPointURIBuilder
import com.chrisdempewolf.pinterest.responses.pin.Pins
import com.chrisdempewolf.pinterest.responses.user.User
import com.google.gson.Gson
import org.apache.commons.io.IOUtils
import java.io.IOException
import java.net.URISyntaxException

class UserMethodDelegate(private val accessToken: String) {

    fun getUser(userFields: UserFields? = null): User {
        try {
            val response = IOUtils.toString(UserEndPointURIBuilder.buildBaseURI(accessToken, userFields?.build()))
            return Gson().fromJson(response, User::class.java)
        }
        catch (e: URISyntaxException) { throw PinterestException(e.message, e) }
        catch (e: IOException) { throw PinterestException(e.message, e) }
    }
}