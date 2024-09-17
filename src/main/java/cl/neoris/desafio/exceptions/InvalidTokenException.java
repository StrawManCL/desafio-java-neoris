package cl.neoris.desafio.exceptions;

import io.jsonwebtoken.MalformedJwtException;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
