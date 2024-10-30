package org.rabie.hunters_league.exceptions;

public class UserWithEmailNotExistException extends RuntimeException {
    public UserWithEmailNotExistException(String message) {
        super("Error : " + message);
    }
}
