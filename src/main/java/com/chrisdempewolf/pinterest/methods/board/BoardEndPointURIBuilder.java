package com.chrisdempewolf.pinterest.methods.board;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class BoardEndPointURIBuilder {
    private static final String BASE_URL = "https://api.pinterest.com";
    private static final String BOARD_PATH = "/v1/boards/{BOARD_NAME}/";
    private static final String MY_BOARD_PATH = "/v1/me/boards/";

    private static final Pattern BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}");

    private BoardEndPointURIBuilder() {
        throw new IllegalStateException("Instantiation not allowed");
    }

    public static URI buildBoardUri(
            final String accessToken,
            final String boardName,
            final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder(BASE_URL)
                .setPath(BOARD_NAME_PATTERN.matcher(BOARD_PATH).replaceFirst(boardName))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildMyBoardUri(final String accessToken, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder(BASE_URL)
                .setPath(MY_BOARD_PATH)
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }
}
