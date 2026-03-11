package com.movieticket.common.dto.show;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateShowRequest {

    private String theatreId;

    private String screenId;

    private String movieId;

    private LocalDateTime showStartTime;

    private LocalDateTime showEndTime;

    private String language;

    private String format;
}