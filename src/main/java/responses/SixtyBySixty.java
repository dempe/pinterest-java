package responses;

public class SixtyBySixty {
    private final String url;
    private final String width;
    private final String height;

    public SixtyBySixty(String url, String width, String height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SixtyBySixty that = (SixtyBySixty) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        return !(height != null ? !height.equals(that.height) : that.height != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SixtyBySixty{" +
                "url='" + url + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
