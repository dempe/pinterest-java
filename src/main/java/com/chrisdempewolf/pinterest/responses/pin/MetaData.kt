package com.chrisdempewolf.pinterest.responses.pin

class MetaData(val article: Article?, val link: Link?) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val metaData = o as MetaData?

        if (if (article != null) article != metaData!!.article else metaData!!.article != null) return false
        return !if (link != null) link != metaData.link else metaData.link != null

    }

    override fun hashCode(): Int {
        var result = if (article != null) article.hashCode() else 0
        result = 31 * result + if (link != null) link.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "MetaData{" +
                "article=" + article +
                ", link=" + link +
                '}'
    }
}
