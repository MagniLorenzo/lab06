package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {

    private final String msg;
    private static final String DEFAULT_MESSAGE = "Network error: no response";

    public NetworkException() {
        super();
        this.msg = DEFAULT_MESSAGE;
    }

    public NetworkException(final String message) {
        super();
        this.msg = "Network error while sending message: " + message;
    }

    public String toString() {
        String str = msg + "\n";
        return str;
    }

}