package com.chrisdempewolf.pinterest.responses.pin;

import com.google.gson.annotations.SerializedName;

public class Pin {
    private final String id;
    private final Counts counts;
    private final String url;
    private final String note;
    private final String link;
    private final Board board;
    private final Creator creator;
    @SerializedName("created_at")
    private final String createdAt;
    private final String color;
    private final Attribution attribution;
    @SerializedName("metadata")
    private final MetaData metaData;

    public Pin(String id, Counts counts, String url, String note, String link, Board board, Creator creator, String createdAt, String color, Attribution attribution, MetaData metaData) {
        this.id = id;
        this.counts = counts;
        this.url = url;
        this.note = note;
        this.link = link;
        this.board = board;
        this.creator = creator;
        this.createdAt = createdAt;
        this.color = color;
        this.attribution = attribution;
        this.metaData = metaData;
    }

    public String getId() {
        return id;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getUrl() {
        return url;
    }

    public String getNote() {
        return note;
    }

    public String getLink() {
        return link;
    }

    public Board getBoard() {
        return board;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getColor() {
        return color;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pin pin = (Pin) o;

        if (id != null ? !id.equals(pin.id) : pin.id != null) return false;
        if (counts != null ? !counts.equals(pin.counts) : pin.counts != null) return false;
        if (url != null ? !url.equals(pin.url) : pin.url != null) return false;
        if (note != null ? !note.equals(pin.note) : pin.note != null) return false;
        if (link != null ? !link.equals(pin.link) : pin.link != null) return false;
        if (board != null ? !board.equals(pin.board) : pin.board != null) return false;
        if (creator != null ? !creator.equals(pin.creator) : pin.creator != null) return false;
        if (createdAt != null ? !createdAt.equals(pin.createdAt) : pin.createdAt != null) return false;
        if (color != null ? !color.equals(pin.color) : pin.color != null) return false;
        if (attribution != null ? !attribution.equals(pin.attribution) : pin.attribution != null) return false;
        return metaData != null ? metaData.equals(pin.metaData) : pin.metaData == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (counts != null ? counts.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (board != null ? board.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (attribution != null ? attribution.hashCode() : 0);
        result = 31 * result + (metaData != null ? metaData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pin{" +
                "id='" + id + '\'' +
                ", counts=" + counts +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", link='" + link + '\'' +
                ", board=" + board +
                ", creator=" + creator +
                ", createdAt='" + createdAt + '\'' +
                ", color='" + color + '\'' +
                ", attribution=" + attribution +
                ", metaData=" + metaData +
                '}';
    }
}
