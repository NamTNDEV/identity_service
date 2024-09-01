package com.namtndev.identity_service.exception;

import com.namtndev.identity_service.dto.response.ApiResponse;
import com.namtndev.identity_service.libs.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingException(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getCode());
        apiResponse.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e) {
        HttpStatus httpStatus = e.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(httpStatus.getCode());
        apiResponse.setMessage(httpStatus.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String emunKey = e.getFieldError().getDefaultMessage();
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        try {
            httpStatus = HttpStatus.valueOf(emunKey);
        } catch (Exception exp) {
        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(httpStatus.getCode());
        apiResponse.setMessage(httpStatus.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
