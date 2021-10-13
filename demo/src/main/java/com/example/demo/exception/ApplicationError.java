package com.example.demo.exception;

public class ApplicationError {

    private int code;
    private String Message;
    private String details;

    public int getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
