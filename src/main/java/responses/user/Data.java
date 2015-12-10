package responses.user;

import com.google.gson.annotations.SerializedName;

public class Data {
    private final String username;
    private final String bio;
    @SerializedName("first_name")
    private final String firstName;
    @SerializedName("last_name")
    private final String lastName;
    private final String url;
    @SerializedName("created_at")
    private final String createdAt;
    private final String id;
    private final Counts counts;
    private final Image image;

    public Data(String username, String bio, String firstName, String lastName, String url, String createdAt, String id, Counts counts, Image image) {
        this.username = username;
        this.bio = bio;
        this.firstName = firstName;
        this.lastName = lastName;
        this.url = url;
        this.createdAt = createdAt;
        this.id = id;
        this.counts = counts;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getId() {
        return id;
    }

    public Counts getCounts() {
        return counts;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (username != null ? !username.equals(data.username) : data.username != null) return false;
        if (bio != null ? !bio.equals(data.bio) : data.bio != null) return false;
        if (firstName != null ? !firstName.equals(data.firstName) : data.firstName != null) return false;
        if (lastName != null ? !lastName.equals(data.lastName) : data.lastName != null) return false;
        if (url != null ? !url.equals(data.url) : data.url != null) return false;
        if (createdAt != null ? !createdAt.equals(data.createdAt) : data.createdAt != null) return false;
        if (id != null ? !id.equals(data.id) : data.id != null) return false;
        if (counts != null ? !counts.equals(data.counts) : data.counts != null) return false;
        return !(image != null ? !image.equals(data.image) : data.image != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (counts != null ? counts.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                ", counts=" + counts +
                ", image=" + image +
                '}';
    }
}
