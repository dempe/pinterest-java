package com.chrisdempewolf.pinterest;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.chrisdempewolf.pinterest.EndPointURIBuilder.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by evan on 12/14/15.
 */
public class TestEndPointURIBuilder {

    final String accessToken = "testaccesstoken123";
    final String id = "1234567890";
    final String fields = "myFields";
    final String name = "john";
    final String userName = "jsmith";
    final String boardName = "myBoard";

    @Test
    public void testBuildPinUri() throws URISyntaxException {
        final URI actual = buildPinUri(accessToken, id, fields);
        final String expected = "https://api.pinterest.com/v1/pins/" + id + "/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testBuildMyPinUri() throws URISyntaxException {
        final URI actual = buildMyPinUri(accessToken, fields);
        final String expected = "https://api.pinterest.com/v1/me/pins/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testBuildBoardPinUri() throws URISyntaxException {
        final URI actual = buildBoardPinUri(accessToken, name, fields);
        final String expected = "https://api.pinterest.com/v1/boards/" + name + "/pins/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testBuildBoardUri() throws URISyntaxException {
        final URI actual = buildBoardUri(accessToken, userName, boardName, fields);
        final String expected = "https://api.pinterest.com/v1/boards/" + userName + "/" + boardName + "/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testBuildMyBoardUri() throws URISyntaxException {
        final URI actual = buildMyBoardUri(accessToken, fields);
        final String expected = "https://api.pinterest.com/v1/me/boards/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(expected, actual.toString());
    }

}
