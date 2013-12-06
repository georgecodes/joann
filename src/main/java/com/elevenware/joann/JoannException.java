package com.elevenware.joann;

public class JoannException extends RuntimeException {

    public JoannException(String message, Throwable cause) {
        super(message, cause);
    }

    public JoannException(String message) {
        super(message);
    }
}
