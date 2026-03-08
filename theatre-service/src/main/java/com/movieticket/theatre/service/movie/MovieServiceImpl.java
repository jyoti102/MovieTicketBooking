package com.movieticket.theatre.service.movie;

import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.movie.CreateMovieRequest;
import com.movieticket.common.dto.movie.MovieDetailResponse;
import com.movieticket.common.dto.movie.MovieSummaryResponse;
import com.movieticket.common.dto.movie.UpdateMovieRequest;
import com.movieticket.common.entity.movie.Movie;

import com.movieticket.common.mapper.MovieMapper;
import com.movieticket.theatre.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public MovieDetailResponse createMovie(CreateMovieRequest request) {

        Movie movie = movieMapper.toEntity(request);

        movieRepository.save(movie);

        return movieMapper.toDetailResponse(movie);
    }

    @Override
    public MovieDetailResponse getMovieById(String id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        return movieMapper.toDetailResponse(movie);
    }

    @Override
    public PageResponse<MovieSummaryResponse> getMovies(int page, int size) {

        PageRequest pageable = PageRequest.of(page, size);

        Page<Movie> moviePage = movieRepository.findAll(pageable);

        Page<MovieSummaryResponse> responsePage =
                moviePage.map(movieMapper::toSummaryResponse);

        return PageResponse.<MovieSummaryResponse>builder()
                .content(responsePage.getContent())
                .page(responsePage.getNumber())
                .pageSize(responsePage.getSize())
                .totalElements(responsePage.getTotalElements())
                .totalPages(responsePage.getTotalPages())
                .last(responsePage.isLast())
                .build();
    }

    @Override
    public MovieDetailResponse updateMovie(String id, UpdateMovieRequest request) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movieMapper.updateMovieFromRequest(request, movie);

        movieRepository.save(movie);

        return movieMapper.toDetailResponse(movie);
    }

    @Override
    public void deleteMovie(String id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movieRepository.delete(movie);
    }
}