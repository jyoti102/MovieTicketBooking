package com.movieticket.common.exception;

import com.movieticket.common.dto.common.ApiResponse;
import com.movieticket.common.util.ApiResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest request) {

        ApiResponse<Object> response = ApiResponseUtil.failure(
                HttpStatus.BAD_REQUEST,
                "GENERIC_ERROR",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}