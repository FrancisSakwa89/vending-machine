package com.franco.jms.exceptions;

public class SoldOutExcepiton extends RuntimeException {
    private String message;

    public SoldOutExcepiton(String string) {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }

}