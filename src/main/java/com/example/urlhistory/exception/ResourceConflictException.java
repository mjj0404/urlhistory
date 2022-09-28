package com.example.urlhistory.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceConflictException extends DataIntegrityViolationException {

    private String fieldName;

    private String fieldValue;

    public ResourceConflictException(String msg, String fieldName, String fieldValue) {
        super(String.format("'%s' caused conflict in '%s' field\ndetail: '%s'", fieldValue, fieldName, msg));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
