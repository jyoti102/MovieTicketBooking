package com.movieticket.common.dto.movie;

import com.movieticket.common.enums.show.MovieStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMovieRequest {

    private String name;

    private String description;

    private String posterUrl;

    private Integer durationMinutes;

    private String certificate;

    private MovieStatus status;

}