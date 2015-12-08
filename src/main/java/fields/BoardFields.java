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
}
