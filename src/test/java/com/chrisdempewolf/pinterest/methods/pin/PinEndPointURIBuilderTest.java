package com.chrisdempewolf.pinterest.methods.pin;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class PinEndPointURIBuilderTest {
    private static final String ACCESS_TOKEN = "testaccesstoken123";
    private static final String PIN_ID = "1234567890";
    private static final String FIELDS = "myFields";
    private static final String USER_NAME = "jsmith";

    @Test
    public void testBuildPinUri() throws URISyntaxException {
        final URI actualURI = PinEndPointURIBuilder.buildPinUri(ACCESS_TOKEN, PIN_ID, FIELDS);
        final URI expectedURI = new URI("https://api.pinterest.com/v1/pins/" + PIN_ID + "?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildMyPinUri() throws URISyntaxException {
        final URI actualURI = PinEndPointURIBuilder.buildMyPinUri(ACCESS_TOKEN, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/me/pins/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }

    @Test
    public void testBuildBoardPinUri() throws URISyntaxException {
        final URI actualURI = PinEndPointURIBuilder.buildBoardPinUri(ACCESS_TOKEN, USER_NAME, FIELDS);
        final URI expectedURI = new  URI("https://api.pinterest.com/v1/boards/" + USER_NAME + "/pins/?access_token=" + ACCESS_TOKEN + "&fields=" + FIELDS);
        assertEquals(expectedURI, actualURI);
    }
}
