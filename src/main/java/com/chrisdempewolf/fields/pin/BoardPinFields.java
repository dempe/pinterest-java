package com.chrisdempewolf.fields.pin;

import com.chrisdempewolf.fields.BaseFields;
import com.chrisdempewolf.fields.Fields;

public class BoardPinFields extends BaseFields {

    @Override
    public Fields setAll() {
        return this.setId().setName().setUrl();
    }

    public BoardPinFields setId() {
        fields.add("id");
		return this;
    }

    public BoardPinFields setName() {
        fields.add("name");
		return this;
    }

    public BoardPinFields setUrl() {
        fields.add("url");
		return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardPinFields that = (BoardPinFields) o;

        return !(fields != null ? !fields.equals(that.fields) : that.fields != null);

    }

    @Override
    public int hashCode() {
        return fields != null ? fields.hashCode() : 0;
    }

}
