package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.fields.user.UserFields;
import org.junit.Test;

public class STestUser extends BaseSTest {

    @Test
    public void testGetMe() {
        System.out.println(pinterest.getMe());
        System.out.println(pinterest.getMe(new UserFields().withAll()));
    }
}
