package com.yourcodereview.java01.eugenet1024.api.requestValidation;

public class ValidationError {

    private final String fieldName;
    private final String message;

    public ValidationError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
