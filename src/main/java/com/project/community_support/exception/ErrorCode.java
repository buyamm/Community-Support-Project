package com.project.community_support.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed with this phone number", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1002, "User not found!", HttpStatus.BAD_REQUEST),
    WRONG_PHONE_NUMBER(1003, "Wrong phone number",HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(1004, "Wrong password",HttpStatus.BAD_REQUEST),

    ;


    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
