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
}
