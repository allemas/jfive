package com.allemas;

public class InvalidJson extends Exception {
    public InvalidJson(String message) {
        super(message);
    }

    public InvalidJson() {
        super("Invalid JSON");
    }

}
