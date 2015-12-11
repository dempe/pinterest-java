package com.chrisdempewolf.responses.pin;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Article {
    @SerializedName("published_at")
    private final String publishedAt;
    private final String description;
    private final String name;
    private final Author[] authors;

    public Article(String publishedAt, String description, String name, Author[] authors) {
        this.publishedAt = publishedAt;
        this.description = description;
        this.name = name;
        this.authors = authors;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (publishedAt != null ? !publishedAt.equals(article.publishedAt) : article.publishedAt != null) return false;
        if (description != null ? !description.equals(article.description) : article.description != null) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authors, article.authors);

    }

    @Override
    public int hashCode() {
        int result = publishedAt != null ? publishedAt.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(authors);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "publishedAt='" + publishedAt + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
}
