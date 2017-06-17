package com.chrisdempewolf.pinterest.stests;

import com.chrisdempewolf.pinterest.Pinterest;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

class BaseSTest {
    protected static final String PIN_ID = "422705115002975322";
    protected static final String PIN_WITH_ATTRIBUTION = "12877548912849493";
    protected static final String BOARD_NAME = "francisabila/all-about-me";

    protected final Pinterest pinterest = new Pinterest(loadAccessToken());

    protected static String loadFile(final String resource) throws IOException {
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
