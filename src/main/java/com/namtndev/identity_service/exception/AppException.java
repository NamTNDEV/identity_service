package com.namtndev.identity_service.exception;

import com.namtndev.identity_service.libs.HttpStatus;

public class AppException extends RuntimeException {
    private HttpStatus httpStatus;

    public AppException(HttpStatus httpStatus) {
        super(httpStatus.getMessage());
        this.httpStatus = httpStatus;
    }


    public HttpStatus getErrorCode() {
        return httpStatus;
    }

    public void setErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
