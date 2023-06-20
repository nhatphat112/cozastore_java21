package com.cybersoft.cozastore_java21.exception;

public class UserNotFondException extends RuntimeException{
    private String message;
    public UserNotFondException(String message){
        this.message = message;
    }


}
