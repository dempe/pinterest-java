package com.chrisdempewolf.pinterest.responses;

import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import com.chrisdempewolf.pinterest.responses.pin.Pins;

import java.io.IOException;

//TODO: test values
public class TestPinResponse {

    @Test
    public void testBoardResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/CompleteBoardResponse.json");
        final Pins pins = new Gson().fromJson(response, Pins.class);

        System.out.println(pins);
    }

    @Test
    public void testPinResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/CompletePinResponse.json");
        final PinResponse pinResponse = new Gson().fromJson(response, PinResponse.class);

        System.out.println(pinResponse);
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
