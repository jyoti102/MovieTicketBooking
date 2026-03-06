package com.movieticket.theatre.controller;

import com.movieticket.common.dto.response.common.ApiResponse;
import com.movieticket.common.dto.response.common.PageResponse;
import com.movieticket.common.dto.theatre.TheatreResponse;
import com.movieticket.common.util.ApiResponseUtil;
import com.movieticket.theatre.service.TheatreService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/theatres")
@RequiredArgsConstructor
public class TheatrePublicController {

    private final TheatreService theatreService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TheatreResponse>> getTheatreById(
            @PathVariable String id,
            HttpServletRequest httpRequest) {

        TheatreResponse response = theatreService.getTheatreById(id);

        ApiResponse<TheatreResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Theatre fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<TheatreResponse>>> getTheatres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest httpRequest) {

        PageResponse<TheatreResponse> response = theatreService.getPublicTheatres(page, size);

        ApiResponse<PageResponse<TheatreResponse>> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Theatres fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ApiResponse<PageResponse<TheatreResponse>>> getTheatresByCity(
            @PathVariable String city,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest httpRequest) {

        PageResponse<TheatreResponse> response =
                theatreService.getTheatresByCity(city, page, size);

        ApiResponse<PageResponse<TheatreResponse>> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Theatres fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

}