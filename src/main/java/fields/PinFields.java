package fields;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class PinFields extends Fields {
    private final CreatorFields creatorFields = new CreatorFields();
    private final BoardFields boardFields = new BoardFields();

    protected boolean link;
    protected boolean counts;
    protected boolean note;
    protected boolean url;

    @Override
    public String build() {
        final String creatorFieldsSerialized = creatorFields.build();
        final String boardFieldsSerialized = boardFields.build();

        return super.build() +
                (isBlank(creatorFieldsSerialized) ? "" : ",creator(" + creatorFields.build() + ")") +
                (isBlank(boardFieldsSerialized) ? "" : ",board(" + boardFields.build() + ")");
    }

    public PinFields setAllFields() {
        this.setAll();
        creatorFields.setAll();
        boardFields.setAll();
        return this;
    }

    public static String defaultFields() {
        return "";
    }

    public CreatorFields getCreatorFields() {
        return creatorFields;
    }

    public BoardFields getBoardFields() {
        return boardFields;
    }

    public PinFields setLink() {
        this.link = true;
		return this;
    }

    public PinFields setCounts() {
        this.counts = true;
		return this;
    }

    public PinFields setNote() {
        this.note = true;
		return this;
    }

    public PinFields setUrl() {
        this.url = true;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PinFields pinFields = (PinFields) o;

        if (link != pinFields.link) return false;
        if (counts != pinFields.counts) return false;
        if (note != pinFields.note) return false;
        if (url != pinFields.url) return false;
        if (creatorFields != null ? !creatorFields.equals(pinFields.creatorFields) : pinFields.creatorFields != null)
            return false;
        return !(boardFields != null ? !boardFields.equals(pinFields.boardFields) : pinFields.boardFields != null);

    }

    @Override
    public int hashCode() {
        int result = creatorFields != null ? creatorFields.hashCode() : 0;
        result = 31 * result + (boardFields != null ? boardFields.hashCode() : 0);
        result = 31 * result + (link ? 1 : 0);
        result = 31 * result + (counts ? 1 : 0);
        result = 31 * result + (note ? 1 : 0);
        result = 31 * result + (url ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PinFields{" +
                "creatorFields=" + creatorFields +
                ", boardFields=" + boardFields +
                ", link=" + link +
                ", counts=" + counts +
                ", note=" + note +
                ", url=" + url +
                '}';
    }
}
