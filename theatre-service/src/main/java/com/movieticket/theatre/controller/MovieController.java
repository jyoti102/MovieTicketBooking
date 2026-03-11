package com.movieticket.theatre.controller;

import com.movieticket.common.dto.common.ApiResponse;
import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.movie.CreateMovieRequest;
import com.movieticket.common.dto.movie.MovieDetailResponse;
import com.movieticket.common.dto.movie.MovieSummaryResponse;
import com.movieticket.common.dto.movie.UpdateMovieRequest;
import com.movieticket.theatre.service.movie.MovieService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/admin/movies")
    public ApiResponse<MovieDetailResponse> createMovie(
            @RequestBody CreateMovieRequest request,
            HttpServletRequest httpRequest) {

        MovieDetailResponse data = movieService.createMovie(request);

        return ApiResponse.<MovieDetailResponse>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("Movie created successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @GetMapping("/movies/{id}")
    public ApiResponse<MovieDetailResponse> getMovieById(
            @PathVariable String id,
            HttpServletRequest httpRequest) {

        MovieDetailResponse data = movieService.getMovieById(id);

        return ApiResponse.<MovieDetailResponse>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Movie fetched successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @GetMapping("/movies")
    public ApiResponse<PageResponse<MovieSummaryResponse>> getMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest httpRequest) {

        PageResponse<MovieSummaryResponse> data = movieService.getMovies(page, size);

        return ApiResponse.<PageResponse<MovieSummaryResponse>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Movies fetched successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @PutMapping("/admin/movies/{id}")
    public ApiResponse<MovieDetailResponse> updateMovie(
            @PathVariable String id,
            @RequestBody UpdateMovieRequest request,
            HttpServletRequest httpRequest) {

        MovieDetailResponse data = movieService.updateMovie(id, request);

        return ApiResponse.<MovieDetailResponse>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Movie updated successfully")
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }

    @DeleteMapping("/admin/movies/{id}")
    public ApiResponse<Void> deleteMovie(
            @PathVariable String id,
            HttpServletRequest httpRequest) {

        movieService.deleteMovie(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Movie deleted successfully")
                .timestamp(LocalDateTime.now())
                .path(httpRequest.getRequestURI())
                .build();
    }
}