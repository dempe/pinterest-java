package pinterest;

import com.google.gson.Gson;
import fields.pin.PinFields;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import responses.pin.Pin;
import responses.pin.Pins;

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

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testBoardWithDefaultFields() throws IOException {
        final Pins pins = pinterest.retrievePinsFromBoardWithDefaultFields(BOARD_NAME);
        System.out.println(pins);
    }

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testBoardWithAllFields() throws IOException {
        final Pins pins = pinterest.retrievePinsFromBoardWithFields("francisabila/all-about-me", new PinFields().setAll());
        System.out.println(pins);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
