package com.chrisdempewolf.pinterest.responses.pin;

import com.google.gson.annotations.SerializedName;

public class Attribution {
    private final String title;
    private final String url;
    @SerializedName("provider_icon_url")
    private final String providerIconUrl;
    @SerializedName("author_name")
    private final String authorName;
    @SerializedName("provider_favicon_url")
    private final String providerFaviconUrl;
    @SerializedName("author_url")
    private final String authorUrl;
    @SerializedName("provider_name")
    private final String providerName;

    public Attribution(String title, String url, String providerIconUrl, String authorName, String providerFaviconUrl, String authorUrl, String providerName) {
        this.title = title;
        this.url = url;
        this.providerIconUrl = providerIconUrl;
        this.authorName = authorName;
        this.providerFaviconUrl = providerFaviconUrl;
        this.authorUrl = authorUrl;
        this.providerName = providerName;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getProviderIconUrl() {
        return providerIconUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getProviderFaviconUrl() {
        return providerFaviconUrl;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public String getProviderName() {
        return providerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribution that = (Attribution) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (providerIconUrl != null ? !providerIconUrl.equals(that.providerIconUrl) : that.providerIconUrl != null)
            return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (providerFaviconUrl != null ? !providerFaviconUrl.equals(that.providerFaviconUrl) : that.providerFaviconUrl != null)
            return false;
        if (authorUrl != null ? !authorUrl.equals(that.authorUrl) : that.authorUrl != null) return false;
        return providerName != null ? providerName.equals(that.providerName) : that.providerName == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (providerIconUrl != null ? providerIconUrl.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (providerFaviconUrl != null ? providerFaviconUrl.hashCode() : 0);
        result = 31 * result + (authorUrl != null ? authorUrl.hashCode() : 0);
        result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attribution{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", providerIconUrl='" + providerIconUrl + '\'' +
                ", authorName='" + authorName + '\'' +
                ", providerFaviconUrl='" + providerFaviconUrl + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
