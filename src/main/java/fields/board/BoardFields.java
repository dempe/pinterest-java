package fields.board;

import fields.CreatorFields;
import fields.FieldSerializer;
import fields.Fields;

import java.util.HashSet;
import java.util.Set;

public class BoardFields implements Fields {
    private final Set<String> fields = new HashSet<>();
    private final CreatorFields creatorFields = new CreatorFields();

    @Override
    public String build() {
        return FieldSerializer.serialize(fields);
    }

    @Override
    public Fields setAll() {
        return this.setCounts().setCreatedAt().setDescription().setId().setImage().setName().setUrl();
    }

    public BoardFields setId() {
        this.fields.add("id");
        return this;
    }

    public BoardFields setName() {
        this.fields.add("name");
        return this;
    }

    public BoardFields setUrl() {
        this.fields.add("url");
        return this;
    }

    public BoardFields setDescription() {
        this.fields.add("description");
        return this;
    }

    public BoardFields setCreatedAt() {
        this.fields.add("created_at");
        return this;
    }

    public BoardFields setCounts() {
        this.fields.add("counts");
        return this;
    }

    public BoardFields setImage() {
        this.fields.add("image");
        return this;
    }
}
