package com.chrisdempewolf.pinterest.methods.board;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class BoardEndPointURIBuilderTest {
    private static final String ACCESS_TOKEN = "testaccesstoken123";
    private static final String FIELDS = "myFields";
    private static final String BOARD_NAME = "jsmith/myBoard";

    @Test
    public void testBuildBoardUri() throws URISyntaxException {
        final URI actualURI = BoardEndPointURIBuilder.buildBoardUri(ACCESS_TOKEN, BOARD_NAME, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/boards/" + BOARD_NAME + "/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildMyBoardUri() throws URISyntaxException {
        final URI actualURI = BoardEndPointURIBuilder.buildMyBoardUri(ACCESS_TOKEN, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/me/boards/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }
}
