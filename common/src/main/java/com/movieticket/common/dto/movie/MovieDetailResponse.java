package com.movieticket.common.dto.movie;

import com.movieticket.common.enums.show.MovieStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MovieDetailResponse {

    private String id;

    private String name;

    private Double rating;

    private Integer votes;

    private String posterUrl;

    private MovieStatus status;

    private List<String> languages;

    private List<String> formats;

    private Integer durationMinutes;

    private List<String> genres;

    private String certificate;

    private String description;
}