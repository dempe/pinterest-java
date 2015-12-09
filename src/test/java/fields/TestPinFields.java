package fields;

import fields.pin.PinFields;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPinFields {
    private static final Pattern CREATOR_PATTERN = Pattern.compile("creator\\([a-z,_]*\\)");
    private static final Pattern BOARD_PATTERN = Pattern.compile("board\\([a-z,]*\\)");
    private static final String ALL_FIELDS_SERIALIZED = "id,url,link,note,metadata,counts,creator(id,first_name,last_name,url),board(id,name,url)";
    private static final String SERIALIZED_CREATOR_FIELDS = "id,first_name,last_name,url";
    private static final String SERIALIZED_BOARD_FIELDS = "id,name,url";

    @Test
    public void testAllFields() {
        final String fields = new PinFields().setAll().build();
        assertSubFields(fields, SERIALIZED_CREATOR_FIELDS, CREATOR_PATTERN);
        assertSubFields(fields, SERIALIZED_BOARD_FIELDS, BOARD_PATTERN);

        final List<String> pinFields = Arrays.asList(BOARD_PATTERN.matcher(
                                        CREATOR_PATTERN.matcher(fields).replaceAll("")).replaceAll("").split(","));

        for (final String subString : pinFields) {
            assertTrue(subString + " not found.", ALL_FIELDS_SERIALIZED.contains(subString));
        }
    }

    @Test
    public void testNoFields() {
        assertEquals("", new PinFields().build());
    }

    @Test
    public void testFieldsIndividually() {
        assertEquals("url", new PinFields().setUrl().build());
        assertEquals("note", new PinFields().setNote().build());
        assertEquals("metadata", new PinFields().setMetadata().build());
    }

    @Test
    public void testCreatorFields() {
        final PinFields pinFields = new PinFields();
        pinFields.getCreatorFields().setFirstName().setLastName();
        assertSubFields(pinFields.build(), "creator(first_name,last_name)", CREATOR_PATTERN);
    }

    private void assertSubFields(
            final String actualFields,
            final String expectedFields,
            final Pattern fieldPattern) {
        final Matcher matcher = fieldPattern.matcher(actualFields);
        matcher.find();
        final String fields = matcher.group();
        final List<String> fieldList = Arrays.asList(
                fields.replaceAll("creator|board|\\(|\\)", "").split(","));

        for (final String subString : fieldList) {
            assertTrue(subString + " not found.", expectedFields.contains(subString));
        }
    }
}
