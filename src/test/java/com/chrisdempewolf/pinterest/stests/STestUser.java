package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.board.BoardFields;
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
        System.out.println(pinterest.getSuggestedBoards());
        System.out.println(pinterest.getSuggestedBoards(new BoardFields().withName()));
    }
}
