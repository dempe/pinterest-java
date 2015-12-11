package com.chrisdempewolf.responses.pin;

public class PinResponse {
    private final Pin pin;

    public PinResponse(Pin pin) {
        this.pin = pin;
    }

    public Pin getPin() {
        return pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PinResponse pinResponse = (PinResponse) o;

        return !(pin != null ? !pin.equals(pinResponse.pin) : pinResponse.pin != null);
    }

    @Override
    public int hashCode() {
        return pin != null ? pin.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PinResponse{" +
                "pin=" + pin +
                '}';
    }
}
