package com.example.homework.homeworkcollectionsone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AbsentVariableException extends RuntimeException {
}
