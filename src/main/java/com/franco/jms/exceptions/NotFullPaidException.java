package com.franco.jms.exceptions;

public class NotFullPaidException extends RuntimeException {
    private String message;
    private double remaining;


    public void setMessage(String message) {
        this.message = message;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public NotFullPaidException(String message, double remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public double getRemaining(){
        return remaining;
    }

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return "NotFullPaidException{" +
                "message='" + message + '\'' +
                ", remaining=" + remaining +
                '}';
    }
}
