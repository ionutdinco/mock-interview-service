package com.fullstack.mockinterviewservice.error;

public class DomainEmptyException extends Exception{
    public DomainEmptyException(String message) {
        super(message);
    }

    public DomainEmptyException() {
        super();
    }
}
