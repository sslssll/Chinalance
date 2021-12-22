package com.chinafree.position.exception;

public class PositionException extends RuntimeException {

    private Integer messageCode;
    public PositionException(){

    }

    public PositionException(Integer messageCode,String message){
        super(message);
        this.messageCode = messageCode;
    }

}