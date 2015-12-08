package responses;

import java.util.Arrays;

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

        for (int i = 0; i < data.length; i++) {
            if (data[i] != pins.getData()[i]) return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
