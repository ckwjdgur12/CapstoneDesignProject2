package kr.ac.knu.CapstoneDesignProject2.rest.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

}
