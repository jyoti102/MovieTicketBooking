package com.movieticket.common.util;


import com.movieticket.common.dto.response.common.ApiResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponseUtil {

    public static <T> ApiResponse<T> success(HttpStatus status, String message, T data, String path) {

        return ApiResponse.<T>builder()
                .success(true)
                .status(status.value())
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(path)
                .build();
    }

    public static <T> ApiResponse<T> failure(HttpStatus status, String errorCode, String message, String path) {

        return ApiResponse.<T>builder()
                .success(false)
                .status(status.value())
                .errorCode(errorCode)
                .message(message)
                .timestamp(LocalDateTime.now())
                .path(path)
                .build();
    }
}