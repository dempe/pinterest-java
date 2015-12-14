package com.chrisdempewolf.pinterest.exceptions;

public class PinterestException extends RuntimeException {

    public PinterestException() {
        super();
    }

    public PinterestException(String message) {
        super(message);
    }

    public PinterestException(String message, Throwable cause) {
        super(message, cause);
    }

    public PinterestException(Throwable cause) {
        super(cause);
    }

    protected PinterestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
