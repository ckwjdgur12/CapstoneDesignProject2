package kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler;

public class MyNotFoundException extends RuntimeException{

    public MyNotFoundException(String message) {
        super(message);
    }

    public MyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNotFoundException(Throwable cause) {
        super(cause);
    }

}
