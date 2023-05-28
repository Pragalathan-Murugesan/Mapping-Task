package com.example.MappingTask.GlobalException;

public class UnauthorizedException extends  RuntimeException{
    public UnauthorizedException(String message){
        super(message);
    }
}
