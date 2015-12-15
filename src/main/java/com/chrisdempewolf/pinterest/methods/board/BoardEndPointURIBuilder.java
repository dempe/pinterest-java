package com.chrisdempewolf.pinterest.methods.board;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class BoardEndPointURIBuilder {
    private static final String PROTOCOL = "https";
    private static final String HOST = "api.pinterest.com";
    private static final String BOARD_PATH = "/v1/boards/{USER_NAME}/{BOARD_NAME}/";
    private static final String MY_BOARD_PATH = "/v1/me/boards/";

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
