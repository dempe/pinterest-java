package com.chrisdempewolf.pinterest.methods.network;

public class ResponseMessageAndStatusCode {
    private final int statusCode;
    private final String message;

    public ResponseMessageAndStatusCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
