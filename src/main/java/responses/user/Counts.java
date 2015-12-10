package responses.user;

public class Counts {
    private final int pins;
    private final int following;
    private final int followers;
    private final int boards;
    private final int likes;

    public Counts(int pins, int following, int followers, int boards, int likes) {
        this.pins = pins;
        this.following = following;
        this.followers = followers;
        this.boards = boards;
        this.likes = likes;
    }

    public int getPins() {
        return pins;
    }

    public int getFollowing() {
        return following;
    }

    public int getFollowers() {
        return followers;
    }

    public int getBoards() {
        return boards;
    }

    public int getLikes() {
        return likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counts counts = (Counts) o;

        if (pins != counts.pins) return false;
        if (following != counts.following) return false;
        if (followers != counts.followers) return false;
        if (boards != counts.boards) return false;
        return likes == counts.likes;

    }

    @Override
    public int hashCode() {
        int result = pins;
        result = 31 * result + following;
        result = 31 * result + followers;
        result = 31 * result + boards;
        result = 31 * result + likes;
        return result;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "pins=" + pins +
                ", following=" + following +
                ", followers=" + followers +
                ", boards=" + boards +
                ", likes=" + likes +
                '}';
    }
}
