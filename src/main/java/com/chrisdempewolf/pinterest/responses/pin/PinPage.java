package com.chrisdempewolf.pinterest.responses.pin;

public class PinPage {
    private final String cursor;
    private final String next;

    public PinPage(String cursor, String next) {
        this.cursor = cursor;
        this.next = next;
    }

    public String getCursor() {
        return cursor;
    }

    public String getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PinPage page = (PinPage) o;

        if (cursor != null ? !cursor.equals(page.cursor) : page.cursor != null) return false;
        return !(next != null ? !next.equals(page.next) : page.next != null);

    }

    @Override
    public int hashCode() {
        int result = cursor != null ? cursor.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Page{" +
                "cursor='" + cursor + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}
