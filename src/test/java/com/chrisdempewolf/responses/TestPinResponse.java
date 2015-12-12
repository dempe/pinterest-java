package com.chrisdempewolf.responses;

import com.chrisdempewolf.responses.pin.PinResponse;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import com.chrisdempewolf.responses.pin.Pins;

import java.io.IOException;

//TODO: test values
public class TestPinResponse {

    @Test
    public void testBoardResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/responses/CompleteBoardResponse.json");
        final Pins pins = new Gson().fromJson(response, Pins.class);

        System.out.println(pins);
    }

    @Test
    public void testPinResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/responses/CompletePinResponse.json");
        final PinResponse pinResponse = new Gson().fromJson(response, PinResponse.class);

        System.out.println(pinResponse);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
