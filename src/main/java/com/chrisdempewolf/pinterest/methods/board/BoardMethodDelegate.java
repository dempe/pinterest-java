package com.chrisdempewolf.pinterest.methods.board;

import com.chrisdempewolf.pinterest.exceptions.PinterestException;
import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.responses.board.BoardPage;
import com.chrisdempewolf.pinterest.responses.board.BoardResponse;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.buildBoardUri;
import static com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.buildMyBoardUri;

public class BoardMethodDelegate {
    private final String accessToken;

    public BoardMethodDelegate(String accessToken) {
        this.accessToken = accessToken;
    }

    public BoardResponse getBoard(final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, null)), BoardResponse.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public BoardResponse getBoard(final String boardName, final BoardFields boardFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(accessToken, boardName, boardFields.build())), BoardResponse.class);
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

    public Boards getNextPageOfBoards(final BoardPage page) {
        if (page == null || page.getNext() == null) { return null; }

        try {
            return new Gson().fromJson(IOUtils.toString(new URI(page.getNext())), Boards.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }
}
