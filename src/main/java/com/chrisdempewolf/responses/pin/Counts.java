package com.chrisdempewolf.responses.pin;

public class Counts {
    private final Integer likes;
    private final Integer comments;
    private final Integer repins;

    public Counts(Integer likes, Integer comments, Integer repins) {
        this.likes = likes;
        this.comments = comments;
        this.repins = repins;
    }

    public Integer getLikes() {
        return likes;
    }

    public Integer getComments() {
        return comments;
    }

    public Integer getRepins() {
        return repins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counts counts = (Counts) o;

        if (likes != null ? !likes.equals(counts.likes) : counts.likes != null) return false;
        if (comments != null ? !comments.equals(counts.comments) : counts.comments != null) return false;
        return !(repins != null ? !repins.equals(counts.repins) : counts.repins != null);

    }

    @Override
    public int hashCode() {
        int result = likes != null ? likes.hashCode() : 0;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (repins != null ? repins.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "likes=" + likes +
                ", comments=" + comments +
                ", repins=" + repins +
                '}';
    }
}
