package com.movieticket.common.dto.common;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private boolean success;
    private int status;
    private String message;
    private String errorCode;
    private T data;
    private LocalDateTime timestamp;
    private String path;
}