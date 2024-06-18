package com.example.homework.homeworkcollectionsone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class WrongDepartmentIdException extends RuntimeException{
    public WrongDepartmentIdException() {
    }

    public WrongDepartmentIdException(String message) {
        super(message);
    }

    public WrongDepartmentIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDepartmentIdException(Throwable cause) {
        super(cause);
    }

    public WrongDepartmentIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
