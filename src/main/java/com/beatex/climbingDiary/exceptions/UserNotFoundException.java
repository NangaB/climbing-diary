package com.beatex.climbingDiary.exceptions;

public class UserNotFoundException extends Exception{

    String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
}
