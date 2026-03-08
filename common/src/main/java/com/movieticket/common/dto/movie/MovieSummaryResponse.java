package com.movieticket.common.dto.movie;

import com.movieticket.common.enums.show.MovieStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovieSummaryResponse {

    private String id;

    private String name;

    private Double rating;

    private Integer votes;

    private String posterUrl;

    private MovieStatus status;
}