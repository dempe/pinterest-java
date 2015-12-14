package com.chrisdempewolf.pinterest;

import com.chrisdempewolf.pinterest.exceptions.PinterestException;
import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import com.chrisdempewolf.pinterest.responses.board.BoardPage;
import com.chrisdempewolf.pinterest.responses.board.BoardResponse;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import com.chrisdempewolf.pinterest.responses.pin.PinPage;
import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.chrisdempewolf.pinterest.responses.pin.Pins;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildBoardPinUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildBoardUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildMyBoardUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildMyPinUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildPinUri;

public class Pinterest {
    private final String accessToken;

    public Pinterest(String accessToken) {
        this.accessToken = accessToken;
    }

    public PinResponse getPin(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, null)), PinResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public PinResponse getPin(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, pinFields.build())), PinResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins getMyPins() {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins getMyPins(final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins getPinsFromBoard(final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins getPinsFromBoard(final String boardName, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public BoardResponse getBoard(final String userName, final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, userName, boardName, null)), BoardResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public BoardResponse getBoard(final String boardName, final String userName, final BoardFields boardFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, userName, boardFields.build())), BoardResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Boards getMyBoards() {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, null)), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Boards getMyBoards(final BoardFields boardFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, boardFields.build())), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins getNextPageOfPins(final PinPage page) {
        try {
            return new Gson().fromJson(IOUtils.toString(new URI(page.getNext())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Boards getNextPageOfBoards(final BoardPage boardPage) {
        try {
            return new Gson().fromJson(IOUtils.toString(new URI(boardPage.getNext())), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }
}
