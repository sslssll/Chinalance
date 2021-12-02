package com.chinafree.auth.model.exception;

public class SystemException extends RuntimeException{
    private String messageCode;
    public SystemException(){

    }
    public SystemException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }
}
