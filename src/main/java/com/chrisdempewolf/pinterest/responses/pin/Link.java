package com.chrisdempewolf.pinterest.responses.pin;

import com.google.gson.annotations.SerializedName;

public class Link {
    private final String locale;
    private final String title;
    @SerializedName("site_name")
    private final String siteName;
    private final String description;
    private final String favicon;

    public Link(String locale, String title, String siteName, String description, String favicon) {
        this.locale = locale;
        this.title = title;
        this.siteName = siteName;
        this.description = description;
        this.favicon = favicon;
    }

    public String getLocale() {
        return locale;
    }

    public String getTitle() {
        return title;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getDescription() {
        return description;
    }

    public String getFavicon() {
        return favicon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (locale != null ? !locale.equals(link.locale) : link.locale != null) return false;
        if (title != null ? !title.equals(link.title) : link.title != null) return false;
        if (siteName != null ? !siteName.equals(link.siteName) : link.siteName != null) return false;
        if (description != null ? !description.equals(link.description) : link.description != null) return false;
        return !(favicon != null ? !favicon.equals(link.favicon) : link.favicon != null);
    }

    @Override
    public int hashCode() {
        int result = locale != null ? locale.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (favicon != null ? favicon.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "locale='" + locale + '\'' +
                ", title='" + title + '\'' +
                ", siteName='" + siteName + '\'' +
                ", description='" + description + '\'' +
                ", favicon='" + favicon + '\'' +
                '}';
    }
}
