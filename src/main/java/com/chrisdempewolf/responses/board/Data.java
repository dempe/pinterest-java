package com.chrisdempewolf.responses.board;

import com.google.gson.annotations.SerializedName;

public class Data {
    private final String description;
    private final String url;
    @SerializedName("created_at")
    private final String createdAt;
    private final String id;
    private final String name;
    private final Counts counts;
    private final Image image;

    public Data(String description, String url, String createdAt, String id, String name, Counts counts, Image image) {
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

        Data data = (Data) o;

        if (description != null ? !description.equals(data.description) : data.description != null) return false;
        if (url != null ? !url.equals(data.url) : data.url != null) return false;
        if (createdAt != null ? !createdAt.equals(data.createdAt) : data.createdAt != null) return false;
        if (id != null ? !id.equals(data.id) : data.id != null) return false;
        if (name != null ? !name.equals(data.name) : data.name != null) return false;
        if (counts != null ? !counts.equals(data.counts) : data.counts != null) return false;
        return !(image != null ? !image.equals(data.image) : data.image != null);

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
        return "Data{" +
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
