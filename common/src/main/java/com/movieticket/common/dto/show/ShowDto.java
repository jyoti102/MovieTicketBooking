package com.movieticket.common.dto.show;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ShowDto {

    private String id;

    private LocalDateTime startTime;

    private String screenType;
}