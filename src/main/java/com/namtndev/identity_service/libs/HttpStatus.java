package com.namtndev.identity_service.libs;

public enum HttpStatus {
    // Success Codes
    SUCCESS_OK(200, "Operation completed successfully"),
    SUCCESS_CREATED(201, "Resource created successfully"),
    SUCCESS_NO_CONTENT(204, "Operation completed successfully, no content returned"),

    // Error Codes
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    USER_ALREADY_EXISTS(409, "User already exists"),
    INVALID_USERNAME(400, "Invalid username: must be at least 4 characters"),
    INVALID_PASSWORD(400, "Invalid password: must be at least 6 characters"),

    // Additional Errors for completeness
    NOT_FOUND(404, "Resource not found"),
    METHOD_NOT_ALLOWED(405, "HTTP method not allowed"),
    UNAUTHORIZED(401, "Unauthorized access"),
    FORBIDDEN(403, "Access forbidden");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
