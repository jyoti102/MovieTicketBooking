package com.movieticket.common.dto.screen;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenResponse {

    private String id;

    private String theatreId;

    private String name;

    private Integer totalRows;

    private Integer totalColumns;

    private Integer totalSeats;

    private String screenType;
}