package com.example.homework.homeworkcollectionsone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
        super("В штате не хватает места для нового сотрудника");
    }
}
