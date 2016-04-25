package com.chrisdempewolf.pinterest.methods.pin;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class PinEndPointURIBuilder {
    private static final String BASE_URL = "https://api.pinterest.com";
    private static final String BOARD_PIN_PATH = "/v1/boards/{BOARD_NAME}/pins/";
    private static final String PIN_PATH = "/v1/pins/{PIN_ID}/";
    private static final String MY_PIN_PATH = "/v1/me/pins/";

    private static final Pattern PIN_PATTERN = Pattern.compile("\\{PIN_ID\\}");
    private static final Pattern BOARD_NAME_PATTERN = Pattern.compile("\\{BOARD_NAME\\}");

    private PinEndPointURIBuilder() {
        throw new IllegalStateException("Instantiation not allowed");
    }

    public static URI buildPinUri(final String accessToken, final String id, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder(BASE_URL)
                .setPath(PIN_PATTERN.matcher(PIN_PATH).replaceFirst(id))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildMyPinUri(final String accessToken, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder =  new URIBuilder(BASE_URL)
                .setPath(MY_PIN_PATH)
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }

    public static URI buildBoardPinUri(final String accessToken, final String name, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder(BASE_URL)
                .setPath(BOARD_NAME_PATTERN.matcher(BOARD_PIN_PATH).replaceFirst(name))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }
}
