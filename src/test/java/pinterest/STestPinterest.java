package pinterest;

import com.google.gson.Gson;
import fields.PinFields;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import responses.Pin;
import responses.Pins;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class STestPinterest {
    private static final String PIN_ID = "525091637782793357";

    private final Pinterest pinterest = new Pinterest("ARp8HNzfw2scBtJqtYA57a8xFeAqFBzML4SnnEZCe9w6DeAJGAAAAAA");

    @Test
    public void testPinWithFields() throws IOException {
        final Pin actualPin = pinterest.retrievePinWithFields(PIN_ID, new PinFields().setAllFields());
        final Pin expectedPin = new Gson().fromJson(loadFile("responses/CompletePinResponse.json"), Pin.class);

        assertEquals(expectedPin, actualPin);
    }

    @Test
    public void testPinWithDefaultFields() throws IOException {
        final Pin actualPin = pinterest.retrievePinWithDefaultFields(PIN_ID);
        final Pin expectedPin = new Gson().fromJson(loadFile("responses/DefaultPinResponse.json"), Pin.class);

        assertEquals(expectedPin, actualPin);
    }

    @Test
    public void testBoardWithDefaultFields() throws IOException {
        final Pins actualPins = pinterest.retrievePinsFromBoard("francisabila/all-about-me");
        final Pins expectedPins = new Gson().fromJson(loadFile("responses/DefaultBoardResponse.json"), Pins.class);

        assertEquals(expectedPins, actualPins);
    }

    @Test
    public void testBoardWithAllFields() throws IOException {
        final Pins actualPins = pinterest.retrievePinsFromBoard("francisabila/all-about-me", new PinFields().setAllFields());
        final Pins expectedPins = new Gson().fromJson(loadFile("responses/CompleteBoardResponse.json"), Pins.class);

        assertEquals(expectedPins, actualPins);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
