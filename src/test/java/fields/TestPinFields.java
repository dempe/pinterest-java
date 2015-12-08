package fields;

import fields.pin.PinFields;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestPinFields {
    private static final String ALL_FIELDS_SERIALIZED = "id,url,link,note,metadata,counts,creator(id,first_name,last_name,url),board(id,name,url)";

    @Test
    public void testAllFields() {
        final List<String> fieldList = Arrays.asList(new PinFields().setAll().build().split(","));

        for (final String subString : fieldList) {
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
    }
}
