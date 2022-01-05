package com.deliveroo.assignment.exception;

public class WrongOrderParsingException extends RuntimeException {

    public WrongOrderParsingException(String errorMessage) {
        super(errorMessage);
    }
}
