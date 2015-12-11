package com.chrisdempewolf.fields.board;

import com.chrisdempewolf.fields.BaseFields;

public class BoardFields extends BaseFields {

    @Override
    public BoardFields setAll() {
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
