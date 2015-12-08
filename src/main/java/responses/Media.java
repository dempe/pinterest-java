package responses;

public class Media {
    private final String type;

    public Media(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;

        return !(type != null ? !type.equals(media.type) : media.type != null);

    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Media{" +
                "type='" + type + '\'' +
                '}';
    }
}
