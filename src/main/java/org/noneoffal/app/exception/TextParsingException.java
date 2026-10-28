package org.noneoffal.app.exception;

public class TextParsingException extends RuntimeException {

    public TextParsingException(String message) {
        super(message);
    }

    public TextParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}