package com.epam.javaCore1.homework.ojectModelPublicTransport.exceptions;

public final class NotSupportedTransportException extends PublicTransportException {
    public NotSupportedTransportException() {
        super("This mode of transport is not supported.");
    }

    public NotSupportedTransportException(String message) {
        super(message);
    }
}
