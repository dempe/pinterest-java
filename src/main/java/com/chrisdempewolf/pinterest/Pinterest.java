package com.chrisdempewolf.pinterest;

import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import com.chrisdempewolf.pinterest.methods.board.BoardMethodDelegate;
import com.chrisdempewolf.pinterest.methods.pin.PinMethodDelegate;
import com.chrisdempewolf.pinterest.responses.board.BoardPage;
import com.chrisdempewolf.pinterest.responses.board.BoardResponse;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import com.chrisdempewolf.pinterest.responses.pin.PinPage;
import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.chrisdempewolf.pinterest.responses.pin.Pins;

public class Pinterest {
    private final PinMethodDelegate pinMethodDelegate;
    private final BoardMethodDelegate boardMethodDelegate;

    public Pinterest(String accessToken) {
        this.pinMethodDelegate = new PinMethodDelegate(accessToken);
        this.boardMethodDelegate = new BoardMethodDelegate(accessToken);
    }

    public PinResponse getPin(final String id) {
        return pinMethodDelegate.getPin(id);
    }

    public boolean deletePin(final String id) {
        return pinMethodDelegate.deletePin(id);
    }

    public PinResponse getPin(final String id, final PinFields pinFields) {
        return pinMethodDelegate.getPin(id, pinFields);
    }

    public Pins getMyPins() {
        return pinMethodDelegate.getMyPins();
    }

    public Pins getMyPins(final PinFields pinFields) {
        return pinMethodDelegate.getMyPins(pinFields);
    }

    public Pins getPinsFromBoard(final String boardName) {
        return pinMethodDelegate.getPinsFromBoard(boardName);
    }

    public Pins getPinsFromBoard(final String boardName, final PinFields pinFields) {
        return pinMethodDelegate.getPinsFromBoard(boardName, pinFields);
    }

    public BoardResponse getBoard(final String boardName) {
        return boardMethodDelegate.getBoard(boardName);
    }

    public BoardResponse getBoard(final String boardName, final BoardFields boardFields) {
        return boardMethodDelegate.getBoard(boardName, boardFields);
    }

    public Boards getMyBoards() {
        return boardMethodDelegate.getMyBoards();
    }

    public Boards getMyBoards(final BoardFields boardFields) {
        return boardMethodDelegate.getMyBoards(boardFields);
    }

    public Pins getNextPageOfPins(final PinPage page) {
        return pinMethodDelegate.getNextPageOfPins(page);
    }

    public Boards getNextPageOfBoards(final BoardPage page) {
        return boardMethodDelegate.getNextPageOfBoards(page);
    }
}
