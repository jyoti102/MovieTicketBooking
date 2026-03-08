package com.movieticket.theatre.controller;

import com.movieticket.common.dto.common.PageResponse;

import com.movieticket.common.dto.movie.CreateMovieRequest;
import com.movieticket.common.dto.movie.MovieDetailResponse;
import com.movieticket.common.dto.movie.MovieSummaryResponse;
import com.movieticket.common.dto.movie.UpdateMovieRequest;
import com.movieticket.theatre.service.movie.MovieService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/admin/movies")
    public MovieDetailResponse createMovie(@RequestBody CreateMovieRequest request) {
        return movieService.createMovie(request);
    }

    @GetMapping("/movies/{id}")
    public MovieDetailResponse getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/movies")
    public PageResponse<MovieSummaryResponse> getMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return movieService.getMovies(page, size);
    }

    @PutMapping("/{id}")
    public MovieDetailResponse updateMovie(
            @PathVariable String id,
            @RequestBody UpdateMovieRequest request) {

        return movieService.updateMovie(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
    }
}