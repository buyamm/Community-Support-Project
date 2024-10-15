package com.project.community_support.exception;

import com.project.community_support.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // cho biet noi xu ly cac exception
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException appException){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(appException.getErrorCode().getCode());
        apiResponse.setMessage(appException.getErrorCode().getMessage());

        return ResponseEntity.status(appException.getErrorCode().getStatusCode()).body(apiResponse);
    }
}
