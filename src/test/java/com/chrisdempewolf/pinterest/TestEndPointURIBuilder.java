package com.chrisdempewolf.pinterest;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildBoardPinUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildBoardUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildMyBoardUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildMyPinUri;
import static com.chrisdempewolf.pinterest.EndPointURIBuilder.buildPinUri;

import static org.junit.Assert.assertEquals;

public class TestEndPointURIBuilder {
    private static final String ACCESS_TOKEN = "testaccesstoken123";
    private static final String PIN_ID = "1234567890";
    private static final String FIELDS = "myFields";
    private static final String USER_NAME = "jsmith";
    private static final String BOARD_NAME = "myBoard";

    @Test
    public void testBuildPinUri() throws URISyntaxException {
        final URI actualURI = buildPinUri(ACCESS_TOKEN, PIN_ID, FIELDS);
        final URI expectedURI = new URI("https://api.pinterest.com/v1/pins/" + PIN_ID + "/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildMyPinUri() throws URISyntaxException {
        final URI actualURI = buildMyPinUri(ACCESS_TOKEN, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/me/pins/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildBoardPinUri() throws URISyntaxException {
        final URI actualURI = buildBoardPinUri(ACCESS_TOKEN, USER_NAME, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/boards/" + USER_NAME + "/pins/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

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
