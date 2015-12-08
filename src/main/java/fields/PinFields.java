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
}
