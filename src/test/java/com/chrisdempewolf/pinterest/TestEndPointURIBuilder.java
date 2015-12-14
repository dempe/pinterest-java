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
        final URI testUri = buildPinUri(accessToken, id, fields);
        final String goal = "https://api.pinterest.com/v1/pins/" + id + "/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(goal, testUri.toString());
    }

    @Test
    public void testBuildMyPinUri() throws URISyntaxException {
        final URI testUri = buildMyPinUri(accessToken, fields);
        final String goal = "https://api.pinterest.com/v1/me/pins/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(goal, testUri.toString());
    }

    @Test
    public void testBuildBoardPinUri() throws URISyntaxException {
        final URI testUri = buildBoardPinUri(accessToken, name, fields);
        final String goal = "https://api.pinterest.com/v1/boards/" + name + "/pins/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(goal, testUri.toString());
    }

    @Test
    public void testBuildBoardUri() throws URISyntaxException {
        final URI testUri = buildBoardUri(accessToken, userName, boardName, fields);
        final String goal = "https://api.pinterest.com/v1/boards/" + userName + "/" + boardName + "/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(goal, testUri.toString());
    }

    @Test
    public void testBuildMyBoardUri() throws URISyntaxException {
        final URI testUri = buildMyBoardUri(accessToken, fields);
        final String goal = "https://api.pinterest.com/v1/me/boards/?access_token=" + accessToken + "&fields=" + fields;

        assertEquals(goal, testUri.toString());
    }

}
