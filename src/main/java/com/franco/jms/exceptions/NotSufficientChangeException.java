package com.franco.jms.exceptions;

public class NotSufficientChangeException extends RuntimeException {
    private String message;

    public NotSufficientChangeException() {
    }

    public NotSufficientChangeException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}