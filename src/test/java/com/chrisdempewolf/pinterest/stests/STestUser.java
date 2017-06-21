package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import com.chrisdempewolf.pinterest.fields.user.UserFields;
import com.chrisdempewolf.pinterest.responses.board.Boards;
import com.chrisdempewolf.pinterest.responses.pin.Pins;
import org.junit.Test;

public class STestUser extends BaseSTest {

    @Test
    public void testGetUser() {
        System.out.println(pinterest.getUser());
        System.out.println(pinterest.getUser(new UserFields().withAll()));
    }

    @Test
    public void testGetSuggestedBoards() {
        System.out.println(pinterest.getUserSuggestedBoards());
        System.out.println(pinterest.getUserSuggestedBoards(new BoardFields().withName()));
    }

    @Test
    public void testGetUserBoards() {
        System.out.println(pinterest.getUserBoards());
        System.out.println(pinterest.getUserBoards(new BoardFields().withName()));
    }

    @Test
    public void testSearchUserBoards() {
        final Boards boards = pinterest.searchUserBoards("new", new BoardFields().withName());
        System.out.println(boards);
        System.out.println(pinterest.getNextPageOfBoards(boards.getNextPage()));
    }

    @Test
    public void testSearchUserPins() {
        final Pins pins = pinterest.searchUserPins("cucumber", new PinFields().withNote());
        System.out.println(pins);
        System.out.println(pinterest.getNextPageOfPins(pins.getNextPage()));
    }

    @Test
    public void testGetUserPins() {
        System.out.println(pinterest.getUserPins());
        System.out.println(pinterest.getUserPins(new PinFields().withCreatedAt()));
    }
}
