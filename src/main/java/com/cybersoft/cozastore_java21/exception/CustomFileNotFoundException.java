package com.cybersoft.cozastore_java21.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CustomFileNotFoundException extends RuntimeException {
    private int statusCode;
    private String message;
    CustomFileNotFoundException(){}
    public CustomFileNotFoundException(int status, String message){
        this.message = message;
        this.statusCode = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
