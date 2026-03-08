package com.movieticket.theatre.service.movie;

import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.movie.CreateMovieRequest;
import com.movieticket.common.dto.movie.MovieDetailResponse;
import com.movieticket.common.dto.movie.MovieSummaryResponse;
import com.movieticket.common.dto.movie.UpdateMovieRequest;

public interface MovieService {

    MovieDetailResponse createMovie(CreateMovieRequest request);

    MovieDetailResponse getMovieById(String id);

    PageResponse<MovieSummaryResponse> getMovies(int page, int size);

    MovieDetailResponse updateMovie(String id, UpdateMovieRequest request);

    void deleteMovie(String id);
}