package fields;

import com.gs.collections.api.block.function.Function;
import com.gs.collections.impl.factory.Lists;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.lowerCase;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;

public class FieldFormatter {

    private static final Function<String, String> TO_LOWERCASE_FUNCTION = new Function<String, String>() {
        public String valueOf(String s) {
            return lowerCase(s);
        }
    };

    public static String format(final String field) {
        return join(Lists.mutable.of(splitByCharacterTypeCamelCase(field))
                .collect(TO_LOWERCASE_FUNCTION)
                .toList(), "_");
    }
}
