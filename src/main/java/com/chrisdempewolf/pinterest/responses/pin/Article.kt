package com.chrisdempewolf.pinterest.responses.pin

import com.google.gson.annotations.SerializedName

import java.util.Arrays

class Article(@SerializedName("published_at")
              val publishedAt: String?, val description: String?, val name: String?, val authors: Array<Author>) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val article = o as Article?

        if (if (publishedAt != null) publishedAt != article!!.publishedAt else article!!.publishedAt != null) return false
        if (if (description != null) description != article.description else article.description != null) return false
        if (if (name != null) name != article.name else article.name != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authors, article.authors)

    }

    override fun hashCode(): Int {
        var result = if (publishedAt != null) publishedAt.hashCode() else 0
        result = 31 * result + if (description != null) description.hashCode() else 0
        result = 31 * result + if (name != null) name.hashCode() else 0
        result = 31 * result + Arrays.hashCode(authors)
        return result
    }

    override fun toString(): String {
        return "Article{" +
                "publishedAt='" + publishedAt + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                '}'
    }
}
