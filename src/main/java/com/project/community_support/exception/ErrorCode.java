package com.project.community_support.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User existed with this phone number or this identifier number", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1002, "User not found!", HttpStatus.BAD_REQUEST),

    WRONG_PHONE_NUMBER(1003, "Wrong phone number",HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD(1004, "Wrong password",HttpStatus.BAD_REQUEST),

    PHONE_NUMBER_INVALID(1005, "Phone number must be 10 character", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1006, "Password must be at least 8 character", HttpStatus.BAD_REQUEST),
    CCCD_INVALID(1007, "CCCD must be at least 12 character", HttpStatus.BAD_REQUEST),


    INVALID_KEY(8888, "Invalid message key", HttpStatus.BAD_REQUEST),
//    UNAUTHENTICATED(9999, "", HttpStatus.BAD_REQUEST);
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
