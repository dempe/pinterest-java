package responses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pins {
    private final Data[] data;

    public Pins(Data[] data) {
        this.data = data;
    }

    public Data[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pins pins = (Pins) o;

        if (pins.getData().length != data.length) return false;

        // disregard order
        final Set<Data> thiz = new HashSet<>(Arrays.asList(this.getData()));
        final Set<Data> that = new HashSet<>(Arrays.asList(pins.getData()));

        return thiz.equals(that);
    }

    @Override
    public int hashCode() {
        if (data == null) return 0;

        int result = 1;

        for (final Data datum : data) {
            result = result * 31 + (datum == null ? 0 : datum.hashCode());
        }

        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
