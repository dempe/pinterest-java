package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import com.chrisdempewolf.pinterest.responses.pin.Pin;
import com.chrisdempewolf.pinterest.responses.pin.PinPage;
import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.chrisdempewolf.pinterest.responses.pin.Pins;
import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class PinSTest extends BaseSTest {
    @Test
    public void testPinWithAttribution() throws IOException {
        final PinResponse actualPinResponse = pinterest.getPin(PIN_WITH_ATTRIBUTION, new PinFields().withAll());
        final PinResponse expectedPinResponse = new Gson().fromJson(loadFile("com/chrisdempewolf/pin_with_attribution.json"), PinResponse.class);
        assertEquals(expectedPinResponse, actualPinResponse);
    }

    @Test
    public void testPinWithAllFields() throws IOException {
        final PinResponse actualPinResponse = pinterest.getPin(PIN_ID, new PinFields().withAll());
        final PinResponse expectedPinResponse = new Gson().fromJson(loadFile("com/chrisdempewolf/complete_pin_response.json"), PinResponse.class);
        assertEquals(expectedPinResponse, actualPinResponse);
    }

    @Test
    public void testPinWithDefaultFields() throws IOException {
        final PinResponse actualPinResponse = pinterest.getPin(PIN_ID);
        final PinResponse expectedPinResponse = new Gson().fromJson(loadFile("com/chrisdempewolf/default_pin_response.json"), PinResponse.class);
        assertEquals(expectedPinResponse, actualPinResponse);
    }

    @Test
    public void testBoardPinsWithDefaultFields() throws IOException {
        final Pins pins = pinterest.getPinsFromBoard(BOARD_NAME);

        assertNotNull(pins.getNextPage());
        assertNotNull(pins.getPins());

        for (final Pin pin : pins) {
            assertNotNull(pin.toString(), pin.getId());
            assertNotNull(pin.toString(), pin.getNote());
            assertNotNull(pin.toString(), pin.getUrl());
            assertNotNull(pin.toString(), pin.getLink());
            assertNull(pin.toString(), pin.getCounts());
            assertNull(pin.toString(), pin.getBoard());
            assertNull(pin.toString(), pin.getColor());
            assertNull(pin.toString(), pin.getCreatedAt());
            assertNull(pin.toString(), pin.getCreator());
            assertNull(pin.toString(), pin.getAttribution());
            assertNull(pin.toString(), pin.getMetaData());
        }
    }

    @Test
    public void testBoardPinsWithAllFields() throws IOException {
        final Pins pins = pinterest.getPinsFromBoard(BOARD_NAME, new PinFields().withAll());

        assertNotNull(pins.getNextPage());
        assertNotNull(pins.getPins());

        for (final Pin pin : pins) {
            assertNotNull(pin.toString(), pin.getId());
            assertNotNull(pin.toString(), pin.getNote());
            assertNotNull(pin.toString(), pin.getUrl());
            assertNotNull(pin.toString(), pin.getLink());
            assertNotNull(pin.toString(), pin.getCounts());
            assertNotNull(pin.toString(), pin.getBoard());
            assertNotNull(pin.toString(), pin.getColor());
            assertNotNull(pin.toString(), pin.getCreatedAt());
            assertNotNull(pin.toString(), pin.getCreator());
            assertNull(pin.toString(),    pin.getAttribution()); //attribution is null for this Pin
            assertNotNull(pin.toString(), pin.getMetaData());
        }
    }

    @Test
    public void testGetNextPageOfPins() {
        final PinPage page = pinterest.getPinsFromBoard(BOARD_NAME).getNextPage();
        final Pins pins = pinterest.getNextPageOfPins(page);
        assertNotNull(pins);
    }
}
