package fields;

public class CreatorFields extends Fields {
    protected boolean id;
    protected boolean firstName;
    protected boolean lastName;
    protected boolean url;

    @Override
    public String build() {
        return super.build();
    }

    public CreatorFields setId() {
        this.id = true;
		return this;
    }

    public CreatorFields setFirstName() {
        this.firstName = true;
		return this;
    }

    public CreatorFields setLastName() {
        this.lastName = true;
		return this;
    }

    public CreatorFields setUrl() {
        this.url = true;
		return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatorFields that = (CreatorFields) o;

        if (id != that.id) return false;
        if (firstName != that.firstName) return false;
        if (lastName != that.lastName) return false;
        return url == that.url;

    }

    @Override
    public int hashCode() {
        int result = (id ? 1 : 0);
        result = 31 * result + (firstName ? 1 : 0);
        result = 31 * result + (lastName ? 1 : 0);
        result = 31 * result + (url ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreatorFields{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", url=" + url +
                '}';
    }
}
