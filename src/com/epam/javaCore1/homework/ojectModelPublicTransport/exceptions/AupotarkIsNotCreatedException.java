package com.epam.javaCore1.homework.ojectModelPublicTransport.exceptions;

public final class AupotarkIsNotCreatedException extends PublicTransportException {

    public AupotarkIsNotCreatedException() {
        super("Fleet Not created.\n" +
                "To work with the fleet, you need to create it.");
    }

    public AupotarkIsNotCreatedException(String message) {
        super(message);
    }
}
