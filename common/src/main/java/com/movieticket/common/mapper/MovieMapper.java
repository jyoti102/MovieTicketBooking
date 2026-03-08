package com.movieticket.common.mapper;

import com.movieticket.common.dto.movie.CreateMovieRequest;
import com.movieticket.common.dto.movie.MovieDetailResponse;
import com.movieticket.common.dto.movie.MovieSummaryResponse;
import com.movieticket.common.dto.movie.UpdateMovieRequest;
import com.movieticket.common.entity.movie.Movie;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    // Create Movie
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rating", constant = "0.0")
    @Mapping(target = "votes", constant = "0")
    @Mapping(target = "status", constant = "COMING_SOON")
    Movie toEntity(CreateMovieRequest request);


    // Summary response for listing
    MovieSummaryResponse toSummaryResponse(Movie movie);


    // Detail response
    MovieDetailResponse toDetailResponse(Movie movie);


    // Update existing movie
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMovieFromRequest(UpdateMovieRequest request, @MappingTarget Movie movie);

}