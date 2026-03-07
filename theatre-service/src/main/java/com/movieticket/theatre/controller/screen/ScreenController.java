package com.movieticket.theatre.controller.screen;

import com.movieticket.common.dto.common.ApiResponse;
import com.movieticket.common.dto.screen.CreateScreenRequest;
import com.movieticket.common.dto.screen.ScreenResponse;
import com.movieticket.common.util.ApiResponseUtil;
import com.movieticket.theatre.service.screen.ScreenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    /**
     * Add screen to theatre
     */
    @PostMapping("/theatres/{theatreId}/screens")
    public ResponseEntity<ApiResponse<ScreenResponse>> createScreen(
            @PathVariable String theatreId,
            @RequestBody CreateScreenRequest request,
            HttpServletRequest httpRequest) {

        ScreenResponse response = screenService.createScreen(theatreId, request);

        ApiResponse<ScreenResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.CREATED,
                        "Screen created successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    /**
     * Get all screens of theatre
     */
    @GetMapping("/theatres/{theatreId}/screens")
    public ResponseEntity<ApiResponse<List<ScreenResponse>>> getScreensByTheatre(
            @PathVariable String theatreId,
            HttpServletRequest httpRequest) {

        List<ScreenResponse> response = screenService.getScreensByTheatre(theatreId);

        ApiResponse<List<ScreenResponse>> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Screens fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Get screen by id
     */
    @GetMapping("/screens/{screenId}")
    public ResponseEntity<ApiResponse<ScreenResponse>> getScreenById(
            @PathVariable String screenId,
            HttpServletRequest httpRequest) {

        ScreenResponse response = screenService.getScreenById(screenId);

        ApiResponse<ScreenResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Screen fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Update screen
     */
    @PutMapping("/screens/{screenId}")
    public ResponseEntity<ApiResponse<ScreenResponse>> updateScreen(
            @PathVariable String screenId,
            @RequestBody CreateScreenRequest request,
            HttpServletRequest httpRequest) {

        ScreenResponse response = screenService.updateScreen(screenId, request);

        ApiResponse<ScreenResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Screen updated successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    /**
     * Delete screen
     */
    @DeleteMapping("/screens/{screenId}")
    public ResponseEntity<ApiResponse<Void>> deleteScreen(
            @PathVariable String screenId,
            HttpServletRequest httpRequest) {

        screenService.deleteScreen(screenId);

        ApiResponse<Void> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Screen deleted successfully",
                        null,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }
}