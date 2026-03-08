package com.movieticket.common.dto.movie;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateMovieRequest {

    @NotBlank
    private String name;

    private String description;

    private String posterUrl;

    private Integer durationMinutes;

    private String certificate;

    private LocalDate releaseDate;

    private List<String> languages;

    private List<String> formats;

    private List<String> genres;
}