package pinterest;

import com.google.gson.Gson;
import fields.pin.PinFields;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import responses.Pin;
import responses.Pins;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class STestPinterest {
    private static final String PIN_ID = "422705115002975322";
    private static final String BOARD_NAME = "francisabila/all-about-me";

    private final Pinterest pinterest = new Pinterest("ARp8HNzfw2scBtJqtYA57a8xFeAqFBzML4SnnEZCe9w6DeAJGAAAAAA");

    @Test
    public void testPinWithAllFields() throws IOException {
        final Pin actualPin = pinterest.retrievePinWithFields(PIN_ID, new PinFields().setAll());
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
        final Pins actualPins = pinterest.retrievePinsFromBoardWithDefaultFields(BOARD_NAME);
        final Pins expectedPins = new Gson().fromJson(loadFile("responses/DefaultBoardResponse.json"), Pins.class);

        assertEquals(expectedPins, actualPins);
    }

    @Test
    public void testBoardWithAllFields() throws IOException {
        final Pins actualPins = pinterest.retrievePinsFromBoardWithFields("francisabila/all-about-me", new PinFields().setAll());
        final Pins expectedPins = new Gson().fromJson(loadFile("responses/CompleteBoardResponse.json"), Pins.class);

        assertEquals(expectedPins, actualPins);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
