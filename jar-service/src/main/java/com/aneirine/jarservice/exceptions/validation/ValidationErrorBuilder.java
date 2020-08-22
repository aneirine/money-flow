package com.aneirine.jarservice.exceptions.validation;

import java.util.List;

public class ValidationErrorBuilder {

    public static ValidationError fromBindingErrors(List<String> errors) {
        ValidationError error = new ValidationError("Validation failed. " + errors.size() + " error(s)");
        for (String stringError : errors) {
            error.addValidationError(stringError);
        }
        return error;
    }

}
