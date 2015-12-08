package pinterest;

import com.google.gson.Gson;
import exceptions.PinterestException;
import fields.PinFields;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;
import responses.Pin;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Pinterest {
    private static final String PROTOCOL = "https";
    private static final String HOST = "api.pinterest.com";
    private static final String PIN_PATH = "/v1/pins/{PIN_ID}/";

    private final String accessToken;

    public Pinterest(String accessToken) {
        this.accessToken = accessToken;
    }

    public Pin getPin(final String id) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, PinFields.defaultFields())), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public Pin getPin(final String id, final PinFields pinFields) {
        try {
            return new Gson().fromJson(IOUtils.toString(buildPinUri(id, pinFields.build())), Pin.class);
        } catch (URISyntaxException | IOException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    private URI buildPinUri(final String id, final String fields) throws URISyntaxException {
        return new URIBuilder()
                .setScheme(PROTOCOL)
                .setHost(HOST)
                .setPath(PIN_PATH.replace("{PIN_ID}", id))
                .setParameter("access_token", accessToken)
                .setParameter("fields", fields)
                .build();
    }
}
