package com.movieticket.theatre.controller;

import com.movieticket.common.dto.common.ApiResponse;
import com.movieticket.common.dto.show.CreateShowRequest;
import com.movieticket.common.dto.show.ShowResponse;
import com.movieticket.common.dto.show.TheatreShowResponse;
import com.movieticket.common.dto.show.UpdateShowRequest;
import com.movieticket.theatre.service.ShowService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping("/admin/shows")
    public ApiResponse<TheatreShowResponse> createShow(
            @RequestBody CreateShowRequest request,
            HttpServletRequest httpRequest) {

        TheatreShowResponse data = showService.createShow(request);

        return ApiResponse.<TheatreShowResponse>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("Show created successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @GetMapping("/shows/{id}")
    public ApiResponse<ShowResponse> getShow(
            @PathVariable String id,
            HttpServletRequest httpRequest) {

        ShowResponse data = showService.getShow(id);

        return ApiResponse.<ShowResponse>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Show fetched successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @GetMapping("/shows")
    public ApiResponse<List<ShowResponse>> getAllShows(
            HttpServletRequest httpRequest) {

        List<ShowResponse> data = showService.getAllShows();

        return ApiResponse.<List<ShowResponse>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Shows fetched successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @PutMapping("/admin/shows/{id}")
    public ApiResponse<ShowResponse> updateShow(
            @PathVariable String id,
            @RequestBody UpdateShowRequest request,
            HttpServletRequest httpRequest) {

        ShowResponse data = showService.updateShow(id, request);

        return ApiResponse.<ShowResponse>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Show updated successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @DeleteMapping("/admin/shows/{id}")
    public ApiResponse<Void> deleteShow(
            @PathVariable String id,
            HttpServletRequest httpRequest) {

        showService.deleteShow(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Show deleted successfully")
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }
}