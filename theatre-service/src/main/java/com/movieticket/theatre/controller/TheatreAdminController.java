package com.movieticket.theatre.controller;

import com.movieticket.common.dto.common.ApiResponse;
import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.theatre.CreateTheatreRequest;
import com.movieticket.common.dto.theatre.TheatreResponse;
import com.movieticket.common.dto.theatre.UpdateTheatreRequest;
import com.movieticket.common.util.ApiResponseUtil;
import com.movieticket.theatre.service.TheatreService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/theatres")
@RequiredArgsConstructor
public class TheatreAdminController {

    private final TheatreService theatreService;

    @PostMapping
    public ResponseEntity<ApiResponse<TheatreResponse>> createTheatre(
            @RequestBody CreateTheatreRequest request,
            HttpServletRequest httpRequest) {

        TheatreResponse response = theatreService.createTheatre(request);

        ApiResponse<TheatreResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.CREATED,
                        "Theatre created successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TheatreResponse>> updateTheatre(
            @PathVariable String id,
            @RequestBody UpdateTheatreRequest request,
            HttpServletRequest httpRequest) {

        TheatreResponse response = theatreService.updateTheatre(id, request);

        ApiResponse<TheatreResponse> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Theatre updated successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TheatreResponse>> getTheatre(
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
    public ResponseEntity<ApiResponse<PageResponse<TheatreResponse>>> getAllTheatres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest httpRequest) {

        PageResponse<TheatreResponse> response = theatreService.getAllTheatres(page, size);

        ApiResponse<PageResponse<TheatreResponse>> apiResponse =
                ApiResponseUtil.success(
                        HttpStatus.OK,
                        "Theatres fetched successfully",
                        response,
                        httpRequest.getRequestURI());

        return ResponseEntity.ok(apiResponse);
    }

}