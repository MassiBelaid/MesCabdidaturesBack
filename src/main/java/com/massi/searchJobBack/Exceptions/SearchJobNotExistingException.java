package com.massi.searchJobBack.Exceptions;

import org.springframework.http.HttpStatus;

public class SearchJobNotExistingException extends Exception{
    private String value;
    private String classC;
    private String field;

    public SearchJobNotExistingException(String value, String classC, String field) {
        this.value = value;
        this.classC = classC;
        this.field = field;
    }

    public String getMessage() {
        return new StringBuilder()
                .append(this.classC)
                .append(" avec ")
                .append(this.field)
                .append(": ")
                .append(this.value)
                .append(" n'existe pas.").toString();

    }

    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }
}
