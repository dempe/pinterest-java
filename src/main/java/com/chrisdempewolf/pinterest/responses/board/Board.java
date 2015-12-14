package com.chrisdempewolf.pinterest.responses.board;

import com.google.gson.annotations.SerializedName;

public class Board {
    private final String description;
    private final String url;
    @SerializedName("created_at")
    private final String createdAt;
    private final String id;
    private final String name;
    private final Counts counts;
    private final Image image;

    public Board(String description, String url, String createdAt, String id, String name, Counts counts, Image image) {
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.counts = counts;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Counts getCounts() {
        return counts;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (description != null ? !description.equals(board.description) : board.description != null) return false;
        if (url != null ? !url.equals(board.url) : board.url != null) return false;
        if (createdAt != null ? !createdAt.equals(board.createdAt) : board.createdAt != null) return false;
        if (id != null ? !id.equals(board.id) : board.id != null) return false;
        if (name != null ? !name.equals(board.name) : board.name != null) return false;
        if (counts != null ? !counts.equals(board.counts) : board.counts != null) return false;
        return !(image != null ? !image.equals(board.image) : board.image != null);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (counts != null ? counts.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pin{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", counts=" + counts +
                ", image=" + image +
                '}';
    }
}
