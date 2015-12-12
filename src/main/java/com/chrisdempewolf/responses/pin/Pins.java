package com.chrisdempewolf.responses.pin;

import com.chrisdempewolf.responses.Page;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Pins implements Iterable<Pin> {
    @SerializedName("data")
    private final List<Pin> pins;
    private final Page page;

    public Pins(Pin[] pins, Page page) {
        this.pins = Arrays.asList(pins);
        this.page = page;
    }

    @Override
    public Iterator<Pin> iterator() {
        return pins.iterator();
    }

    public List<Pin> getPins() {
        return pins;
    }

    public Page getPage() {
        return page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pins pins1 = (Pins) o;

        if (pins != null ? !pins.equals(pins1.pins) : pins1.pins != null) return false;
        return !(page != null ? !page.equals(pins1.page) : pins1.page != null);

    }

    @Override
    public int hashCode() {
        int result = pins != null ? pins.hashCode() : 0;
        result = 31 * result + (page != null ? page.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pins{" +
                "pins=" + pins +
                ", page=" + page +
                '}';
    }
}
