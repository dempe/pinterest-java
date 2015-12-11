package com.chrisdempewolf.responses.pin;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Pins implements Iterable<Pin> {
    private final List<Pin> pin;

    public Pins(Pin[] pin) {
        this.pin = Arrays.asList(pin);
    }

    @Override
    public Iterator<Pin> iterator() {
        return pin.iterator();
    }

    public List<Pin> getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pins pins = (Pins) o;

        return !(pin != null ? !pin.equals(pins.pin) : pins.pin != null);

    }

    @Override
    public int hashCode() {
        return pin != null ? pin.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pins{" +
                "pin=" + pin +
                '}';
    }
}
