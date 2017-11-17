package com.chrisdempewolf.pinterest

import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.fields.pin.PinFields
import com.chrisdempewolf.pinterest.fields.user.UserFields
import com.chrisdempewolf.pinterest.methods.board.BoardMethodDelegate
import com.chrisdempewolf.pinterest.methods.network.ResponseMessageAndStatusCode
import com.chrisdempewolf.pinterest.methods.pin.PinMethodDelegate
import com.chrisdempewolf.pinterest.methods.user.UserMethodDelegate
import com.chrisdempewolf.pinterest.responses.board.BoardPage
import com.chrisdempewolf.pinterest.responses.board.BoardResponse
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.chrisdempewolf.pinterest.responses.pin.PinPage
import com.chrisdempewolf.pinterest.responses.pin.PinResponse
import com.chrisdempewolf.pinterest.responses.pin.Pins
import com.chrisdempewolf.pinterest.responses.user.User
import com.chrisdempewolf.pinterest.responses.user.UserPage
import com.chrisdempewolf.pinterest.responses.user.Users

class Pinterest(accessToken: String) {
    private val pinMethodDelegate = PinMethodDelegate(accessToken)
    private val boardMethodDelegate = BoardMethodDelegate(accessToken)
    private val userMethodDelegate = UserMethodDelegate(accessToken)

    fun getPin(id: String): PinResponse
            = pinMethodDelegate.getPin(id, PinFields())

    fun getPin(id: String, pinFields: PinFields): PinResponse
            = pinMethodDelegate.getPin(id, pinFields)

    fun getMyPins(): Pins
            = pinMethodDelegate.getMyPins()

    fun getMyPins(pinFields: PinFields): Pins
            = pinMethodDelegate.getMyPins(pinFields)

    fun getPinsFromBoard(boardName: String): Pins
            = pinMethodDelegate.getPinsFromBoard(boardName)

    fun getPinsFromBoard(boardName: String, pinFields: PinFields): Pins
            = pinMethodDelegate.getPinsFromBoard(boardName, pinFields)

    fun patchPin(pinID: String, board: String? = null, note: String? = null, link: String? = null): ResponseMessageAndStatusCode
            = pinMethodDelegate.patchPin(pinID, board, note, link)

    fun postPin(boardName: String,
                note: String,
                image: String,
                link: String? = null): ResponseMessageAndStatusCode
            = pinMethodDelegate.postPin(boardName, note, image, link)

    fun deletePin(id: String): Boolean
            = pinMethodDelegate.deletePin(id)

    fun deleteBoard(boardName: String): Boolean
            = boardMethodDelegate.deleteBoard(boardName)

    fun postBoard(boardName: String, description: String): ResponseMessageAndStatusCode
            = boardMethodDelegate.postBoard(boardName, description)

    fun patchBoard(boardName: String, name: String? = null, description: String? = null): ResponseMessageAndStatusCode
            = boardMethodDelegate.patchBoard(boardName, name, description)

    fun getBoard(boardName: String): BoardResponse
            = boardMethodDelegate.getBoard(boardName)

    fun getBoard(boardName: String, boardFields: BoardFields): BoardResponse
            = boardMethodDelegate.getBoard(boardName, boardFields)

    fun getMyBoards(): Boards
            = boardMethodDelegate.getMyBoards()

    fun getMyBoards(boardFields: BoardFields): Boards
            = boardMethodDelegate.getMyBoards(boardFields)

    fun getUser(): User
            = userMethodDelegate.get()

    fun getUser(userFields: UserFields): User
            = userMethodDelegate.get(userFields)

    fun getUserBoards(): Boards
            = userMethodDelegate.getBoards()

    fun getUserBoards(boardFields: BoardFields): Boards
            = userMethodDelegate.getBoards(boardFields)

    fun getUserPins(): Pins
            = userMethodDelegate.getPins()

    fun getUserPins(pinFields: PinFields): Pins
            = userMethodDelegate.getPins(pinFields)

    fun getUserSuggestedBoards(): Boards
            = userMethodDelegate.getSuggestedBoards()

    fun getUserSuggestedBoards(boardFields: BoardFields): Boards
            = userMethodDelegate.getSuggestedBoards(boardFields)

    fun searchUserBoards(query: String): Boards
            = userMethodDelegate.searchBoards(query)

    fun searchUserBoards(query: String, boardFields: BoardFields): Boards
            = userMethodDelegate.searchBoards(query, boardFields)

    fun searchUserPins(query: String): Pins
            = userMethodDelegate.searchPins(query)

    fun searchUserPins(query: String, pinFields: PinFields): Pins
            = userMethodDelegate.searchPins(query, pinFields)

    fun getFollowers(): Users
            = userMethodDelegate.getFollowers()

    fun getFollowers(userFields: UserFields): Users
            = userMethodDelegate.getFollowers(userFields)

    fun getFollowing(): Users
            = userMethodDelegate.getFollowing()

    fun getFollowing(userFields: UserFields): Users
            = userMethodDelegate.getFollowing(userFields)

    fun getNextPageOfFollowing(page: UserPage): Users?
            = getNextPageOfUsers(page)

    fun getFollowersBoards(): Boards
            = userMethodDelegate.getFollowersBoards()

    fun getFollowersBoards(boardFields: BoardFields): Boards
            = userMethodDelegate.getFollowersBoards(boardFields)

    fun followBoard(boardName: String): ResponseMessageAndStatusCode
            = userMethodDelegate.followBoard(boardName)

    fun followUser(userName: String): ResponseMessageAndStatusCode
            = userMethodDelegate.followUser(userName)

    fun unfollowBoard(boardName: String): Boolean
            = userMethodDelegate.unfollowBoard(boardName)

    fun unfollowUser(userName: String): Boolean
            = userMethodDelegate.unfollowUser(userName)

    fun getNextPageOfFollowersBoards(page: BoardPage): Boards?
            = getNextPageOfBoards(page)

    fun getNextPageOfPins(page: PinPage): Pins?
            = pinMethodDelegate.getNextPageOfPins(page)

    fun getNextPageOfBoards(page: BoardPage): Boards?
            = boardMethodDelegate.getNextPageOfBoards(page)

    fun getNextPageOfUsers(page: UserPage): Users?
            = userMethodDelegate.getNextPageOfUsers(page)

}
