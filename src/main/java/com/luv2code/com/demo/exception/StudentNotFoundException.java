package com.luv2code.com.demo.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message){
        super(message);
    }
}
