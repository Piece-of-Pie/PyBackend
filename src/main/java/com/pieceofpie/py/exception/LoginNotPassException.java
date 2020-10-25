package com.pieceofpie.py.exception;

public class LoginNotPassException extends RuntimeException {
    public LoginNotPassException(String message) {
        super(message);
    }
}
