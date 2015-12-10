package fields;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseFields implements Fields {
    protected final Set<String> fields = new HashSet<>();

    @Override
    public String build() {
        return FieldSerializer.serialize(fields);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseFields that = (BaseFields) o;

        return !(fields != null ? !fields.equals(that.fields) : that.fields != null);

    }

    @Override
    public int hashCode() {
        return fields != null ? fields.hashCode() : 0;
    }

    @Override
    public String toString() {
        return build();
    }
}
