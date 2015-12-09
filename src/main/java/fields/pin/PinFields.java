package fields.pin;

import fields.BaseFields;
import fields.CreatorFields;

import static fields.FieldSerializer.serialize;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class PinFields extends BaseFields {
    private final CreatorFields creatorFields = new CreatorFields();
    private final BoardFields boardFields = new BoardFields();

    @Override
    public String build() {
        final String creatorFieldsSerialized = creatorFields.build();
        final String boardFieldsSerialized = boardFields.build();

        return serialize(fields) +
                (isBlank(creatorFieldsSerialized) ? "" : ",creator(" + creatorFieldsSerialized + ")") +
                (isBlank(boardFieldsSerialized) ? "" : ",board(" + boardFieldsSerialized + ")");
    }

    // TODO:  is there a better way to do this? i.e., formulaically
    @Override
    public PinFields setAll() {
        this.setCounts().setLink().setMetadata().setNote().setUrl();
        creatorFields.setAll();
        boardFields.setAll();
        return this;
    }

    public CreatorFields getCreatorFields() {
        return creatorFields;
    }

    public BoardFields getBoardFields() {
        return boardFields;
    }

    public PinFields setLink() {
        this.fields.add("link");
		return this;
    }

    public PinFields setCounts() {
        this.fields.add("counts");
		return this;
    }

    public PinFields setNote() {
        this.fields.add("note");
		return this;
    }

    public PinFields setUrl() {
        this.fields.add("url");
        return this;
    }

    public PinFields setMetadata() {
        this.fields.add("metadata");
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PinFields pinFields = (PinFields) o;

        if (creatorFields != null ? !creatorFields.equals(pinFields.creatorFields) : pinFields.creatorFields != null)
            return false;
        if (boardFields != null ? !boardFields.equals(pinFields.boardFields) : pinFields.boardFields != null)
            return false;
        return !(fields != null ? !fields.equals(pinFields.fields) : pinFields.fields != null);

    }

    @Override
    public int hashCode() {
        int result = creatorFields != null ? creatorFields.hashCode() : 0;
        result = 31 * result + (boardFields != null ? boardFields.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PinFields{" +
                "creatorFields=" + creatorFields +
                ", boardFields=" + boardFields +
                ", fields=" + fields +
                '}';
    }
}
