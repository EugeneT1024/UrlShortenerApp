package com.yourcodereview.java01.eugenet1024.api.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {

    private List<ValidationError> errors = new ArrayList<>();

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    public void addError(ValidationError error) {
        if (errors == null) {
            this.errors = new ArrayList<>();
        }
        errors.add(error);
    }

}

