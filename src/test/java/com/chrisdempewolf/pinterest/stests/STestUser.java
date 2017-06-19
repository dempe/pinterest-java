package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.board.BoardFields;
import com.chrisdempewolf.pinterest.fields.pin.PinFields;
import com.chrisdempewolf.pinterest.fields.user.UserFields;
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
    public void testGetUserPins() {
        System.out.println(pinterest.getUserPins());
        System.out.println(pinterest.getUserPins(new PinFields().withCreatedAt()));
    }
}
