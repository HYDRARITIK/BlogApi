package com.hydra.demo.Exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApplicationException extends RuntimeException{
    private final String errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public ApplicationException(String errorCode, String message, HttpStatus httpStatus) {
        super("Application exception occurs");
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
