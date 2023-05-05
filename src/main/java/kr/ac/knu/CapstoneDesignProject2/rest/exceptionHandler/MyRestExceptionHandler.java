package kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyRestExceptionHandler {

    // add exception handling code here

    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> handleException(MyNotFoundException exc){

        // create a MyErrorResponse
        MyErrorResponse error = new MyErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // Exception handler to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<MyErrorResponse> handleException(Exception exc){

        // create a MyErrorResponse
        MyErrorResponse error = new MyErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
