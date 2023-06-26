package com.cybersoft.cozastore_java21.exception;

public class CustomException extends RuntimeException{
    private String message;
    private int statusCode;
    private String data;
    public CustomException(int statusCode,String message,String data){
        this.message = "";
        this.statusCode = statusCode;
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
