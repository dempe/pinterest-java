package com.chrisdempewolf.pinterest

import com.chrisdempewolf.pinterest.fields.board.BoardFields
import com.chrisdempewolf.pinterest.fields.pin.PinFields
import com.chrisdempewolf.pinterest.methods.board.BoardMethodDelegate
import com.chrisdempewolf.pinterest.methods.network.ResponseMessageAndStatusCode
import com.chrisdempewolf.pinterest.methods.pin.PinMethodDelegate
import com.chrisdempewolf.pinterest.responses.board.BoardPage
import com.chrisdempewolf.pinterest.responses.board.BoardResponse
import com.chrisdempewolf.pinterest.responses.board.Boards
import com.chrisdempewolf.pinterest.responses.pin.PinPage
import com.chrisdempewolf.pinterest.responses.pin.PinResponse
import com.chrisdempewolf.pinterest.responses.pin.Pins

class Pinterest(accessToken: String) {
    private val pinMethodDelegate: PinMethodDelegate
    private val boardMethodDelegate: BoardMethodDelegate

    init {
        this.pinMethodDelegate = PinMethodDelegate(accessToken)
        this.boardMethodDelegate = BoardMethodDelegate(accessToken)
    }

    fun getPin(id: String): PinResponse {
        return pinMethodDelegate.getPin(id)
    }

    fun getPin(id: String, pinFields: PinFields): PinResponse {
        return pinMethodDelegate.getPin(id, pinFields)
    }

    fun getMyPins(): Pins {
        return pinMethodDelegate.getMyPins()
    }

    fun getMyPins(pinFields: PinFields): Pins {
        return pinMethodDelegate.getMyPins(pinFields)
    }

    fun getPinsFromBoard(boardName: String): Pins {
        return pinMethodDelegate.getPinsFromBoard(boardName)
    }

    fun getPinsFromBoard(boardName: String, pinFields: PinFields): Pins {
        return pinMethodDelegate.getPinsFromBoard(boardName, pinFields)
    }

    fun postPin(
            boardName: String,
            note: String,
            image: String,
            link: String? = null): ResponseMessageAndStatusCode {
        return pinMethodDelegate.postPin(boardName, note, image, link)
    }

    fun deletePin(id: String): Boolean {
        return pinMethodDelegate.deletePin(id)
    }

    fun deleteBoard(boardName: String): Boolean {
        return boardMethodDelegate.deleteBoard(boardName)
    }

    fun postBoard(boardName: String, description: String): ResponseMessageAndStatusCode {
        return boardMethodDelegate.postBoard(boardName, description)
    }

    fun getBoard(boardName: String): BoardResponse {
        return boardMethodDelegate.getBoard(boardName)
    }

    fun getBoard(boardName: String, boardFields: BoardFields): BoardResponse {
        return boardMethodDelegate.getBoard(boardName, boardFields)
    }

    fun getMyBoards(): Boards {
        return boardMethodDelegate.getMyBoards()
    }

    fun getMyBoards(boardFields: BoardFields): Boards {
        return boardMethodDelegate.getMyBoards(boardFields)
    }

    fun getNextPageOfPins(page: PinPage): Pins? {
        return pinMethodDelegate.getNextPageOfPins(page)
    }

    fun getNextPageOfBoards(page: BoardPage): Boards? {
        return boardMethodDelegate.getNextPageOfBoards(page)
    }
}
