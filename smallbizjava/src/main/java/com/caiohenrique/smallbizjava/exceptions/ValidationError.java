package com.caiohenrique.smallbizjava.exceptions;

import com.caiohenrique.smallbizjava.exceptions.handler.FieldMessage;
import com.caiohenrique.smallbizjava.exceptions.handler.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String message, String error, String path) {
        super(timestamp, status, message, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
