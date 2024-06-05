package com.grapghql.helper;

public class ExceptionHelper {
    public static RuntimeException throwResouceNotFoundException(){
        return new RuntimeException("Resource not found");
    }
}
