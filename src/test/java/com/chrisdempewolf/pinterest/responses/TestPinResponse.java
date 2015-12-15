package com.chrisdempewolf.pinterest.responses;

import com.chrisdempewolf.pinterest.responses.pin.Article;
import com.chrisdempewolf.pinterest.responses.pin.Board;
import com.chrisdempewolf.pinterest.responses.pin.Counts;
import com.chrisdempewolf.pinterest.responses.pin.Creator;
import com.chrisdempewolf.pinterest.responses.pin.Link;
import com.chrisdempewolf.pinterest.responses.pin.MetaData;
import com.chrisdempewolf.pinterest.responses.pin.Pin;
import com.chrisdempewolf.pinterest.responses.pin.PinResponse;
import com.chrisdempewolf.pinterest.responses.pin.Pins;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestPinResponse {

    @Test
    public void testPinsResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/CompleteBoardResponse.json");
        final Pins pins = new Gson().fromJson(response, Pins.class);

        System.out.println(pins);
    }

    @Test
    public void testPinResponse() throws IOException {
        final String response = loadFile("com/chrisdempewolf/CompletePinResponse.json");
        final PinResponse pinResponse = new Gson().fromJson(response, PinResponse.class);
        final Pin pin = pinResponse.getPin();
        final Creator creator = pin.getCreator();
        final Board board = pin.getBoard();
        final Counts counts = pin.getCounts();
        final MetaData metaData = pin.getMetaData();
        final Article article = metaData.getArticle();
        final Link link = metaData.getLink();

        assertEquals("https://www.pinterest.com/pin/422705115002975322/", pin.getUrl());
        assertEquals("2015-06-29T15:46:23", pin.getCreatedAt());
        assertEquals("I got Dulce de leche! What Ice Cream Flavor Are You?", pin.getNote());
        assertEquals("#0a0502", pin.getColor());
        assertEquals("https://www.pinterest.com/r/pin/422705115002975322/4779055074072594921/cd7cbc93cadede3167f390bbbd95ddb91bb3ea50c14178a761a6bebec604e411", pin.getLink());
        assertEquals("422705115002975322", pin.getId());

        assertEquals("https://www.pinterest.com/francisabila/", creator.getUrl());
        assertEquals("Francis", creator.getFirstName());
        assertEquals("Abila ", creator.getLastName());
        assertEquals("422705252433686868", creator.getId());

        assertEquals("https://www.pinterest.com/francisabila/all-about-me/", board.getUrl());
        assertEquals("422705183714461377", board.getId());
        assertEquals("All about me!", board.getName());

        assertEquals(0, counts.getLikes().intValue());
        assertEquals(0, counts.getComments().intValue());
        assertEquals(0, counts.getRepins().intValue());

        assertEquals(null, article.getPublishedAt());
        assertEquals("It's time to separate the rocky roads from the mint chocolate chips.", article.getDescription());
        assertEquals("What Ice Cream Flavor Are You?", article.getName());

        assertEquals("en", link.getLocale());
        assertEquals("What Ice Cream Flavor Are You?", link.getTitle());
        assertEquals("BuzzFeed", link.getSiteName());
        assertEquals("It's time to separate the rocky roads from the mint chocolate chips...", link.getDescription());
        assertEquals("https://s-media-cache-ak0.pinimg.com/favicons/5a2f3ddebb24221ec8a631ee05b7e6418bbb2e7de0f019eab2dd7b32.png?6f90f349a263fafae3843e9decf2812a", link.getFavicon());
    }

    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }
}
