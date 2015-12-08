package responses.pin;

public class Creator {
    private final String url;
    private final String firstName;
    private final String lastName;
    private final String id;

    public Creator(String url, String firstName, String lastName, String id) {
        this.url = url;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creator creator = (Creator) o;

        if (url != null ? !url.equals(creator.url) : creator.url != null) return false;
        if (firstName != null ? !firstName.equals(creator.firstName) : creator.firstName != null) return false;
        if (lastName != null ? !lastName.equals(creator.lastName) : creator.lastName != null) return false;
        return !(id != null ? !id.equals(creator.id) : creator.id != null);

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "url='" + url + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
