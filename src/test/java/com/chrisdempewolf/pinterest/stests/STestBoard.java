package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.methods.network.ResponseMessageAndStatusCode;
import com.chrisdempewolf.pinterest.responses.board.Board;
import com.chrisdempewolf.pinterest.responses.board.BoardResponse;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class STestBoard extends BaseSTest {

    @Test
    public void testBoardPostAndDelete() throws IOException {
        final String boardName = "foo";
        final ResponseMessageAndStatusCode response = pinterest.postBoard(boardName, "test description");

        assertEquals(HttpStatus.SC_CREATED, response.getStatusCode());
        assertTrue(pinterest.deleteBoard("cdatarank/" + boardName));
    }

    @Test
    public void testBoardPatch() throws IOException {
        final String name = "test";
        final String board = "cdatarank/" + name;
        final String description = Long.toString(new Random().nextLong());
        final ResponseMessageAndStatusCode response = pinterest.patchBoard(board, name, description);
        final JSONObject dataObject = new JSONObject(response.getMessage()).getJSONObject("data");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        assertEquals(description, dataObject.getString("description"));
        assertEquals(name, dataObject.getString("name"));
    }

    @Test
    public void testBoardWithDefaultFields() throws IOException {
        final BoardResponse boardResponse = pinterest.getBoard(BOARD_NAME);
        final Board board = boardResponse.getBoard();

        assertNull(board.getCounts());
        assertNull(board.getCreatedAt());
        assertNull(board.getDescription());
        assertNotNull(board.getId());
        assertNull(board.getImage());
        assertNotNull(board.getName());
        assertNotNull(board.getUrl());
    }

    @Test
    public void testBoardWithAllFields() throws IOException {
        final BoardResponse boardResponse = pinterest.getBoard(BOARD_NAME, new BoardFields().withAll());
        final Board board = boardResponse.getBoard();

        assertNotNull(board.getCounts());
        assertNotNull(board.getCreatedAt());
        assertNotNull(board.getDescription());
        assertNotNull(board.getId());
        assertNotNull(board.getImage());
        assertNotNull(board.getName());
        assertNotNull(board.getUrl());
    }

    @Test
    public void testMyBoardWithDefaultFields() throws IOException {
        final Boards boards = pinterest.getMyBoards();
        final List<Board> boardList = boards.getBoards();

        for (final Board board : boardList) {
            assertNull(board.getCounts());
            assertNull(board.getCreatedAt());
            assertNull(board.getDescription());
            assertNotNull(board.getId());
            assertNull(board.getImage());
            assertNotNull(board.getName());
            assertNotNull(board.getUrl());
        }
    }

    @Test
    public void testMyBoardWithAllFields() throws IOException {
        final Boards boards = pinterest.getMyBoards(new BoardFields().withAll());
        final List<Board> boardList = boards.getBoards();

        for (final Board board : boardList) {
            assertNotNull(board.getCounts());
            assertNotNull(board.getCreatedAt());
            assertNotNull(board.getDescription());
            assertNotNull(board.getId());
            assertNotNull(board.getImage());
            assertNotNull(board.getName());
            assertNotNull(board.getUrl());
        }
    }
}
