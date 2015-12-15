package com.chrisdempewolf.pinterest.methods.board;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.buildBoardUri;
import static com.chrisdempewolf.pinterest.methods.board.BoardEndPointURIBuilder.buildMyBoardUri;
import static org.junit.Assert.assertEquals;

public class TestBoardEndPointURIBuilder {
    private static final String ACCESS_TOKEN = "testaccesstoken123";
    private static final String FIELDS = "myFields";
    private static final String USER_NAME = "jsmith";
    private static final String BOARD_NAME = "myBoard";

    @Test
    public void testBuildBoardUri() throws URISyntaxException {
        final URI actualURI = buildBoardUri(ACCESS_TOKEN, USER_NAME, BOARD_NAME, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/boards/" + USER_NAME + "/" + BOARD_NAME + "/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildMyBoardUri() throws URISyntaxException {
        final URI actualURI = buildMyBoardUri(ACCESS_TOKEN, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/me/boards/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }
}
