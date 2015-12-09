package pinterest;

import com.google.gson.Gson;
import exceptions.PinterestException;
import fields.pin.PinFields;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;
import responses.board.Board;
import responses.pin.Pin;
import responses.pin.Pins;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Pinterest {
    private static final String PROTOCOL = "https";
    private static final String HOST = "api.pinterest.com";
    private static final String PIN_PATH = "/v1/pins/{PIN_ID}/";
    private static final String MY_PIN_PATH = "/v1/me/pins/";
    private static final String BOARD_PATH = "/v1/boards/{BOARD_NAME}/pins/";

    private final String accessToken;

    public Pinterest(String accessToken) {
        this.accessToken = accessToken;
    }

    public Pin retrievePinWithDefaultFields(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, null)), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pin retrievePinWithFields(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, pinFields.build())), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrieveMyPinsWithDefaultFields(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrieveMyPinsWithFields(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildMyPinUri(pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoardWithDefaultFields(final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(boardName, null)), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoardWithFields(final String boardName, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(boardName, pinFields.build())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Board retrieveBoardWithDefaultFields(final String boardName, final String userName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(boardName, null)), Board.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    private URI buildPinUri(final String id, final String fields) throws URISyntaxException {
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

    private URI buildMyPinUri(final String fields) throws URISyntaxException {
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

    private URI buildBoardUri(final String name, final String fields) throws URISyntaxException {
        final URIBuilder uriBuilder = new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(BOARD_PATH.replace("{BOARD_NAME}", name))
                .setParameter("access_token", accessToken);

        if (isNotBlank(fields)) {
            uriBuilder.setParameter("fields", fields);
        }

        return uriBuilder.build();
    }
}
