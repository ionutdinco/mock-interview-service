package com.fullstack.mockinterviewservice.error;

public class ProfessionAlreadyExistsException extends Exception {
    public ProfessionAlreadyExistsException() {
        super();
    }

    public ProfessionAlreadyExistsException(String message) {
        super(message);
    }

    public ProfessionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ProfessionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
