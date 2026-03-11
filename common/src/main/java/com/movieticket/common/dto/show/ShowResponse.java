package com.movieticket.common.dto.show;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ShowResponse {

    private String id;

    private LocalDateTime showStartTime;

    private LocalDateTime showEndTime;

    private String language;

    private String format;
}