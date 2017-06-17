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

class Pinterest(accessToken: String) {
    private val pinMethodDelegate: PinMethodDelegate
    private val boardMethodDelegate: BoardMethodDelegate
    private val userMethodDelegate: UserMethodDelegate

    init {
        this.pinMethodDelegate = PinMethodDelegate(accessToken)
        this.boardMethodDelegate = BoardMethodDelegate(accessToken)
        this.userMethodDelegate = UserMethodDelegate(accessToken)
    }

    fun getPin(id: String): PinResponse = pinMethodDelegate.getPin(id, PinFields())

    fun getPin(id: String, pinFields: PinFields): PinResponse = pinMethodDelegate.getPin(id, pinFields)

    fun getMyPins(): Pins = pinMethodDelegate.getMyPins()

    fun getMyPins(pinFields: PinFields): Pins = pinMethodDelegate.getMyPins(pinFields)

    fun getPinsFromBoard(boardName: String): Pins = pinMethodDelegate.getPinsFromBoard(boardName)

    fun getPinsFromBoard(boardName: String, pinFields: PinFields): Pins = pinMethodDelegate.getPinsFromBoard(boardName, pinFields)

    fun patchPin(pinID: String, board: String? = null, note: String? = null, link: String? = null): ResponseMessageAndStatusCode
            = pinMethodDelegate.patchPin(pinID, board, note, link)

    fun postPin(
            boardName: String,
            note: String,
            image: String,
            link: String? = null): ResponseMessageAndStatusCode = pinMethodDelegate.postPin(boardName, note, image, link)

    fun deletePin(id: String): Boolean = pinMethodDelegate.deletePin(id)

    fun deleteBoard(boardName: String): Boolean = boardMethodDelegate.deleteBoard(boardName)

    fun postBoard(boardName: String, description: String): ResponseMessageAndStatusCode = boardMethodDelegate.postBoard(boardName, description)

    fun patchBoard(boardName: String, name: String? = null, description: String? = null): ResponseMessageAndStatusCode
            = boardMethodDelegate.patchBoard(boardName, name, description)

    fun getBoard(boardName: String): BoardResponse = boardMethodDelegate.getBoard(boardName)

    fun getBoard(boardName: String, boardFields: BoardFields): BoardResponse = boardMethodDelegate.getBoard(boardName, boardFields)

    fun getMyBoards(): Boards = boardMethodDelegate.getMyBoards()

    fun getMyBoards(boardFields: BoardFields): Boards = boardMethodDelegate.getMyBoards(boardFields)

    fun getMe(): User = userMethodDelegate.getMe()

    fun getMe(userFields: UserFields): User = userMethodDelegate.getMe(userFields)

    fun getNextPageOfPins(page: PinPage): Pins? = pinMethodDelegate.getNextPageOfPins(page)

    fun getNextPageOfBoards(page: BoardPage): Boards? = boardMethodDelegate.getNextPageOfBoards(page)
}
