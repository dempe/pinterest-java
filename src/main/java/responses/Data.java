package responses;

public class Data {
    private final String id;
    private final Counts counts;
    private final String url;
    private final String note;
    private final String link;
    private final Board board;
    private final Creator creator;
    private final String createdAt;
    private final String color;
    private final String attribution;

    public Data(String id, Counts counts, String url, String note, String link, Board board, Creator creator, String createdAt, String color, String attribution) {
        this.id = id;
        this.counts = counts;
        this.url = url;
        this.note = note;
        this.link = link;
        this.board = board;
        this.creator = creator;
        this.createdAt = createdAt;
        this.color = color;
        this.attribution = attribution;
    }

    public String getId() {
        return id;
    }

    public Counts getCounts() {
        return counts;
    }

    public String getUrl() {
        return url;
    }

    public String getNote() {
        return note;
    }

    public String getLink() {
        return link;
    }

    public Board getBoard() {
        return board;
    }

    public Creator getCreator() {
        return creator;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getColor() {
        return color;
    }

    public String getAttribution() {
        return attribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        if (id != null ? !id.equals(data.id) : data.id != null) return false;
        if (counts != null ? !counts.equals(data.counts) : data.counts != null) return false;
        if (url != null ? !url.equals(data.url) : data.url != null) return false;
        if (note != null ? !note.equals(data.note) : data.note != null) return false;
        if (link != null ? !link.equals(data.link) : data.link != null) return false;
        if (board != null ? !board.equals(data.board) : data.board != null) return false;
        if (creator != null ? !creator.equals(data.creator) : data.creator != null) return false;
        if (createdAt != null ? !createdAt.equals(data.createdAt) : data.createdAt != null) return false;
        if (color != null ? !color.equals(data.color) : data.color != null) return false;
        return !(attribution != null ? !attribution.equals(data.attribution) : data.attribution != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (counts != null ? counts.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (board != null ? board.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (attribution != null ? attribution.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", counts=" + counts +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", link='" + link + '\'' +
                ", board=" + board +
                ", creator=" + creator +
                ", createdAt='" + createdAt + '\'' +
                ", color='" + color + '\'' +
                ", attribution='" + attribution + '\'' +
                '}';
    }
}
