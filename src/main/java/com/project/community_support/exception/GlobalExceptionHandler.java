package com.project.community_support.exception;

import com.project.community_support.dto.response.ApiResponse;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice // cho biet noi xu ly cac exception
@Slf4j
public class GlobalExceptionHandler {
    private static final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException appException){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(appException.getErrorCode().getCode());
        apiResponse.setMessage(appException.getErrorCode().getMessage());

        return ResponseEntity.status(appException.getErrorCode().getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingValidation(MethodArgumentNotValidException exception){
        String numKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode;

        Map<String, Object> attributes = null;

        try{
            errorCode = ErrorCode.valueOf(numKey);
            var constrainViolation = exception.getBindingResult().getAllErrors().getFirst().unwrap(ConstraintViolation.class);
            attributes = constrainViolation.getConstraintDescriptor().getAttributes();

            log.info(attributes.toString());
            /**
             * Console:
             *      {groups=[Ljava.lang.Class;@35dd7336, min=10, message=PHONE_NUMBER_INVALID, payload=[Ljava.lang.Class;@5a441c9}
             * */
        }catch (IllegalArgumentException e){
            errorCode = ErrorCode.INVALID_KEY;
        }

        ApiResponse apiResponse = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(Objects.nonNull(attributes) ? mapAttribute(errorCode.getMessage(), attributes) : errorCode.getMessage())
                .build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    private String mapAttribute(String message, Map<String, Object> attributes) {
        String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE)); // get("min")

        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
    }
}
