package com.chrisdempewolf.responses.pin;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Pins implements Iterable<Pin> {
    @SerializedName("data")
    private final List<Pin> pins;

    public Pins(Pin[] pins) {
        this.pins = Arrays.asList(pins);
    }

    @Override
    public Iterator<Pin> iterator() {
        return pins.iterator();
    }

    public List<Pin> getPins() {
        return pins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pins pins = (Pins) o;

        return !(this.pins != null ? !this.pins.equals(pins.pins) : pins.pins != null);

    }

    @Override
    public int hashCode() {
        return pins != null ? pins.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pins{" +
                "pins=" + pins +
                '}';
    }
}
