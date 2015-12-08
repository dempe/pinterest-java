package responses;

public class Image {
    private final Original original;

    public Image(Original original) {
        this.original = original;
    }

    public Original getOriginal() {
        return original;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return !(original != null ? !original.equals(image.original) : image.original != null);

    }

    @Override
    public int hashCode() {
        return original != null ? original.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Image{" +
                "original=" + original +
                '}';
    }

    private static class Original {
        private final String url;
        private final int width;
        private final int height;

        public Original(String url, int width, int height) {
            this.url = url;
            this.width = width;
            this.height = height;
        }

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Original original = (Original) o;

            if (width != original.width) return false;
            if (height != original.height) return false;
            return !(url != null ? !url.equals(original.url) : original.url != null);

        }

        @Override
        public int hashCode() {
            int result = url != null ? url.hashCode() : 0;
            result = 31 * result + width;
            result = 31 * result + height;
            return result;
        }

        @Override
        public String toString() {
            return "Original{" +
                    "url='" + url + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}
