package fields;

import java.util.Set;
import java.util.regex.Pattern;

public class FieldSerializer {
    private static final Pattern INVALID_CHAR_PATTERN = Pattern.compile("[\\[\\] ]");

    public static String serialize(final Set<String> fields) {
        if (fields == null) { return ""; }
        return INVALID_CHAR_PATTERN.matcher(fields.toString()).replaceAll("");
    }
}
