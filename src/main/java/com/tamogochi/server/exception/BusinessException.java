package com.tamogochi.server.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

    private List<ErrorInfo> errors;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, List<ErrorInfo> errors) {
        this(message);
        this.errors = errors;
    }

    public BusinessException(String message, Throwable cause, List<ErrorInfo> errors) {
        this(message, cause);
        this.errors = errors;
    }

    public List<ErrorInfo> getErrors() {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        return errors;
    }
}
