package com.fullstack.mockinterviewservice.error;

public class ProfessionEmptyException extends Exception{
    public ProfessionEmptyException() {
        super();
    }

    public ProfessionEmptyException(String message) {
        super(message);
    }
}
