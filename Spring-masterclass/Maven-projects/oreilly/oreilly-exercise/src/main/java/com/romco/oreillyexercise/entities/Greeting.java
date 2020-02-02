package com.romco.oreillyexercise.entities;

public class Greeting {
    private String message;

    public Greeting() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting(String message) {
        this.message = message;
    }
}
