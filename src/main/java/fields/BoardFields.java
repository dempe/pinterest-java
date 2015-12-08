package fields;

public class BoardFields extends Fields {
    protected boolean id;
    protected boolean name;
    protected boolean url;

    @Override
    public String build() {
        return super.build();
    }

    public BoardFields setId() {
        this.id = true;
		return this;
    }

    public BoardFields setName() {
        this.name = true;
		return this;
    }

    public BoardFields setUrl() {
        this.url = true;
		return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardFields that = (BoardFields) o;

        if (id != that.id) return false;
        if (name != that.name) return false;
        return url == that.url;

    }

    @Override
    public int hashCode() {
        int result = (id ? 1 : 0);
        result = 31 * result + (name ? 1 : 0);
        result = 31 * result + (url ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BoardFields{" +
                "id=" + id +
                ", name=" + name +
                ", url=" + url +
                '}';
    }
}
