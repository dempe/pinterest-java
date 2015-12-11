package com.chrisdempewolf.responses.pin;

public class Pin {
    private final Data data;

    public Pin(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pin pin = (Pin) o;

        return !(data != null ? !data.equals(pin.data) : pin.data != null);
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pin{" +
                "data=" + data +
                '}';
    }
}
