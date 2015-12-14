package com.chrisdempewolf.pinterest.responses.pin;

public class MetaData {
    private final Article article;
    private final Link link;

    public MetaData(Article article, Link link) {
        this.article = article;
        this.link = link;
    }

    public Article getArticle() {
        return article;
    }

    public Link getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaData metaData = (MetaData) o;

        if (article != null ? !article.equals(metaData.article) : metaData.article != null) return false;
        return !(link != null ? !link.equals(metaData.link) : metaData.link != null);

    }

    @Override
    public int hashCode() {
        int result = article != null ? article.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "article=" + article +
                ", link=" + link +
                '}';
    }
}
