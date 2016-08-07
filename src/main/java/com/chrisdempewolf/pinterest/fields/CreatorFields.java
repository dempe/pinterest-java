package com.chrisdempewolf.pinterest.fields;

public class CreatorFields extends BaseFields {

    @Override
    public Fields setAll() {
        return this.setFirstName().setId().setLastName().setUrl();
    }

    public CreatorFields setId() {
        fields.add("id");
        return this;
    }

    public CreatorFields setFirstName() {
        fields.add("first_name");
        return this;
    }

    public CreatorFields setLastName() {
        fields.add("last_name");
        return this;
    }

    public CreatorFields setUrl() {
        fields.add("url");
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatorFields that = (CreatorFields) o;

        return !(fields != null ? !fields.equals(that.fields) : that.fields != null);
    }

    @Override
    public int hashCode() {
        return fields != null ? fields.hashCode() : 0;
    }

}
