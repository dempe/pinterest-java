package com.chrisdempewolf.pinterest;

import com.chrisdempewolf.fields.board.BoardFields;
import com.chrisdempewolf.fields.pin.PinFields;
import com.chrisdempewolf.responses.board.Board;
import com.chrisdempewolf.responses.board.Boards;
import com.chrisdempewolf.responses.pin.Pin;
import com.chrisdempewolf.responses.pin.PinResponse;
import com.chrisdempewolf.responses.pin.Pins;
import com.google.gson.Gson;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class STestPinterest {
    private static final String PIN_ID = "422705115002975322";
    private static final String BOARD_NAME = "francisabila/all-about-me";

    private final Pinterest pinterest = new Pinterest(loadAccessToken());

    @Test
    public void testPinWithAllFields() throws IOException {
        final PinResponse actualPinResponse = pinterest.retrievePinWithFields(PIN_ID, new PinFields().setAll());
        final PinResponse expectedPinResponse = new Gson().fromJson(loadFile("com/chrisdempewolf/responses/CompletePinResponse.json"), PinResponse.class);
        assertEquals(expectedPinResponse, actualPinResponse);
    }

    @Test
    public void testPinWithDefaultFields() throws IOException {
        final PinResponse actualPinResponse = pinterest.retrievePinWithDefaultFields(PIN_ID);
        final PinResponse expectedPinResponse = new Gson().fromJson(loadFile("com/chrisdempewolf/responses/DefaultPinResponse.json"), PinResponse.class);
        assertEquals(expectedPinResponse, actualPinResponse);
    }

    @Test
    public void testBoardPinsWithDefaultFields() throws IOException {
        final Pins pins = pinterest.retrievePinsFromBoardWithDefaultFields(BOARD_NAME);

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
        final Pins pins = pinterest.retrievePinsFromBoardWithFields("francisabila/all-about-me", new PinFields().setAll());

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
            //assertNotNull(pin.toString(), pin.getAttribution()); attribution is seemingly always null
            assertNotNull(pin.toString(), pin.getMetaData());
        }
    }

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testBoardWithDefaultFields() throws IOException {
        final Board board = pinterest.retrieveBoardWithDefaultFields("francisabila", "all-about-me");
        System.out.println(board);
    }

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testBoardWithAllFields() throws IOException {
        final Board board = pinterest.retrieveBoardWithFields("francisabila", "all-about-me", new BoardFields().setAll());
        System.out.println(board);
    }

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testMyBoardWithDefaultFields() throws IOException {
        final Boards board = pinterest.retrieveMyBoardWithDefaultFields();
        System.out.println(board);
    }

    /**
     * Only testing parsing here - changes too frequently.
     * TODO:  test presence of expected keys
     * @throws IOException
     */
    @Test
    public void testMyBoardWithAllFields() throws IOException {
        final Boards board = pinterest.retrieveMyBoardWithFields(new BoardFields().setAll());
        System.out.println(board);
    }


    private static String loadFile(final String resource) throws IOException {
        return IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
    }

    private static String loadAccessToken() {
        try {
            return FileUtils.readFileToString(FileUtils.getFile(".access_token"), Charsets.UTF_8).replace("\n", "");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
