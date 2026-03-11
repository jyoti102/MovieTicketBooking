package com.movieticket.common.dto.show;

import com.movieticket.common.enums.show.ShowStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateShowRequest {

    private LocalDateTime showStartTime;

    private LocalDateTime showEndTime;

    private String language;

    private String format;

    private ShowStatus status;
}