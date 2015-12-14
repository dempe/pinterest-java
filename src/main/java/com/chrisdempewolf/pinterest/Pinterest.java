package com.chrisdempewolf.pinterest;

import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.google.gson.Gson;
import com.chrisdempewolf.pinterest.exceptions.PinterestException;
import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import org.apache.commons.io.IOUtils;
import com.chrisdempewolf.pinterest.responses.board.BoardResponse;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import com.chrisdempewolf.pinterest.responses.pin.Pins;

import java.io.IOException;
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

    public PinResponse retrievePinWithDefaultFields(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, null)), PinResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public PinResponse retrievePinWithFields(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(accessToken, id, pinFields.build())), PinResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrieveMyPinsWithDefaultFields() {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrieveMyPinsWithFields(final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(accessToken, pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoardWithDefaultFields(final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoardWithFields(final String boardName, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardPinUri(accessToken, boardName, pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public BoardResponse retrieveBoardWithDefaultFields(final String userName, final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, userName, boardName, null)), BoardResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public BoardResponse retrieveBoardWithFields(final String boardName, final String userName, final BoardFields boardFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, userName, boardFields.build())), BoardResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Boards retrieveMyBoardWithDefaultFields() {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, null)), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Boards retrieveMyBoardWithFields(final BoardFields boardFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyBoardUri(accessToken, boardFields.build())), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }
}
