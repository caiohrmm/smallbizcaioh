package com.caiohenrique.smallbizjava.exceptions.handler;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class FieldMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public FieldMessage() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldMessage that = (FieldMessage) o;
        return Objects.equals(fieldName, that.fieldName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, message);
    }
}
