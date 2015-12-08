package fields;

import exceptions.PinterestException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.join;

public abstract class Fields {
    public String build() {
        try {
            final List<String> fields = new ArrayList<>();

            for (final Field field : this.getClass().getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) { continue; }
                if (Modifier.isPrivate(field.getModifiers())) { continue; }
                if (!(Boolean) field.get(this)) { continue; }

                fields.add(FieldFormatter.format(field.getName()));
            }

            return join(fields, ",");
        } catch (IllegalAccessException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }

    public void setAll() {
        try {
            for (final Field field : this.getClass().getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) { continue; }
                if (Modifier.isPrivate(field.getModifiers())) { continue; }
                field.set(this, true);
            }
        } catch (IllegalAccessException e) {
            throw new PinterestException(e.getMessage(), e);
        }
    }
}
