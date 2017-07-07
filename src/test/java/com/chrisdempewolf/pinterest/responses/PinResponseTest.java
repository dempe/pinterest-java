package com.chrisdempewolf.pinterest.responses;

import com.chrisdempewolf.pinterest.responses.pin.Article;
import com.chrisdempewolf.pinterest.responses.pin.Board;
import com.chrisdempewolf.pinterest.responses.pin.Counts;
import com.chrisdempewolf.pinterest.responses.pin.Creator;
import com.chrisdempewolf.pinterest.responses.pin.Link;
import com.chrisdempewolf.pinterest.responses.pin.MetaData;
import com.chrisdempewolf.pinterest.responses.pin.Pin;
import com.chrisdempewolf.pinterest.responses.pin.PinPage;
import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.chrisdempewolf.pinterest.responses.pin.Pins;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PinResponseTest {

    @Test
    public void testPinsResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/complete_pins_response.json");
        final Pins pins = new Gson().fromJson(response, Pins.class);
        final PinPage pinPage = pins.getNextPage();

        assertEquals(25, pins.getPins().size());
        assertEquals("LT40MjI3MDUxMTUwMDI5NTI3OTI6MjV8ZDEyZDM4NTRmMTJjMGQ2NzIzYThmOTRhZjJjM2JlY2YwYTVjNmIwMDk3ZTUzNTJiNTRhYTVkNjAyMmRiNjM4Yg==", pinPage.getCursor());
        assertEquals("https://api.pinterest.com/v1/boards/francisabila/all-about-me/pins/?access_token=ACCESS_TOKEN&fields=id%2Clink%2Ccounts%2Cnote%2Curl%2Ccreator%28id%2Cfirst_name%2Clast_name%2Curl%29%2Cboard%28id%2Cname%2Curl%29%2Cmetadata&cursor=LT40MjI3MDUxMTUwMDI5NTI3OTI6MjV8ZDEyZDM4NTRmMTJjMGQ2NzIzYThmOTRhZjJjM2JlY2YwYTVjNmIwMDk3ZTUzNTJiNTRhYTVkNjAyMmRiNjM4Yg%3D%3D", pinPage.getNext());
    }

    @Test
    public void testPinResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/complete_pin_response.json");
        final PinResponse pinResponse = new Gson().fromJson(response, PinResponse.class);
        final Pin pin = pinResponse.getPin();
        final Creator creator = pin.getCreator();
        final Board board = pin.getBoard();
        final Counts counts = pin.getCounts();
        final MetaData metaData = pin.getMetaData();
        final Article article = metaData.getArticle();
        final Link link = metaData.getLink();

        assertEquals("https://www.pinterest.com/pin/525091637795429035/", pin.getUrl());
        assertEquals("2017-06-17T14:22:33", pin.getCreatedAt());
        assertEquals(" ", pin.getNote());
        assertEquals("#152431", pin.getColor());
        assertEquals("", pin.getLink());
        assertEquals("525091637795429035", pin.getId());

        assertEquals("https://www.pinterest.com/cdatarank/", creator.getUrl());
        assertEquals("chris ", creator.getFirstName());
        assertEquals("datarank", creator.getLastName());
        assertEquals("525091775212175196", creator.getId());

        assertEquals("https://www.pinterest.com/cdatarank/this-is-a-new-board/", board.getUrl());
        assertEquals("525091706493087676", board.getId());
        assertEquals("this is a new board", board.getName());

        assertEquals(0, counts.getComments().intValue());
        assertEquals(0, counts.getSaves().intValue());
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
