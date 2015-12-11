package com.chrisdempewolf.pinterest;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class EndPointURIBuilder {
    private static final String PROTOCOL = "https";
    private static final String HOST = "api.pinterest.com";
    private static final String PIN_PATH = "/v1/pins/{PIN_ID}/";
    private static final String MY_PIN_PATH = "/v1/me/pins/";
    private static final String BOARD_PIN_PATH = "/v1/boards/{BOARD_NAME}/pins/";
    private static final String BOARD_PATH = "/v1/boards/{USER_NAME}/{BOARD_NAME}/";
    private static final String MY_BOARD_PATH = "/v1/me/boards/";

    public static URI buildPinUri(final String accessToken, final String id, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder =  new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(PIN_PATH.replace("{PIN_ID}", id))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildMyPinUri(final String accessToken, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder =  new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(MY_PIN_PATH)
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildBoardPinUri(final String accessToken, final String name, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(BOARD_PIN_PATH.replace("{BOARD_NAME}", name))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildBoardUri(final String accessToken, final String userName, final String boardName, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(BOARD_PATH.replace("{USER_NAME}", userName).replace("{BOARD_NAME}", boardName))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildMyBoardUri(final String accessToken, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(MY_BOARD_PATH)
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }
}
