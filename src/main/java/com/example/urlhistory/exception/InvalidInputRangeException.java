package com.example.urlhistory.exception;

public class InvalidInputRangeException extends IllegalArgumentException {

    private static final long serialVersionUID = 2L;
    private String fieldName;
    private Object fieldValue;

    public InvalidInputRangeException(String fieldName, Object fieldValue) {
        super(String.format("%s exceeds %s valid input range.", fieldValue, fieldName));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
