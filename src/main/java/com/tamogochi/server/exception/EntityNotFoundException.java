package com.tamogochi.server.exception;

import java.util.List;

public class EntityNotFoundException extends BusinessException{

    private final static String DEFAULT_MESSAGE = "Entity not found";

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, List<ErrorInfo> errors) {
        super(message, errors);
    }

    public EntityNotFoundException(String message, Throwable cause, List<ErrorInfo> errors) {
        super(message, cause, errors);
    }
}
