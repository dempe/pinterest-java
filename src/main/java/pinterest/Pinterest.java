package pinterest;

import com.google.gson.Gson;
import exceptions.PinterestException;
import fields.PinFields;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;
import responses.Pin;
import responses.Pins;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Pinterest {
    private static final String PROTOCOL = "https";
    private static final String HOST = "api.pinterest.com";
    private static final String PIN_PATH = "/v1/pins/{PIN_ID}/";
    private static final String BOARD_PATH = "/v1/boards/{BOARD_NAME}/pins/";

    private final String accessToken;

    public Pinterest(String accessToken) {
        this.accessToken = accessToken;
    }

    public Pin retrievePin(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, null)), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pin retrievePin(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, pinFields.build())), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoard(final String boardName) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(boardName, PinFields.defaultFields())), Pins.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pins retrievePinsFromBoard(final String boardName, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildBoardUri(boardName, pinFields.build())), Pins.class);
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

    private URI buildBoardUri(final String name, final String fields) throws URISyntaxException {
        return new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(BOARD_PATH.replace("{BOARD_NAME}", name))
                .setParameter("access_token", accessToken)
                .setParameter("fields", fields)
                .build();
    }
}
