package com.example.ArtHub;

import java.util.List;

public class AppValidationError extends AppError {
    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public AppValidationError(List<String> errors) {
        super("Validation Error");
        this.errors = errors;
    }
}