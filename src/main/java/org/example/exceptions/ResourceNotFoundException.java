package org.example.exceptions;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(){
        super("Resource not found");
    }
}
