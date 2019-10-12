package com.tamogochi.server.exception;

import java.util.List;

public class IncorrectRequestException extends BusinessException{

    private final static String DEFAULT_MESSAGE = "Incorrect request";

    public IncorrectRequestException(String message) {
        super(message);
    }

    public IncorrectRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRequestException(String message, List<ErrorInfo> errors) {
        super(message, errors);
    }

    public IncorrectRequestException(String message, Throwable cause, List<ErrorInfo> errors) {
        super(message, cause, errors);
    }
}
