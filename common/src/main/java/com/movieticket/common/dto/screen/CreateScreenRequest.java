package com.movieticket.common.dto.screen;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateScreenRequest {

    @NotBlank(message = "Screen name is required")
    private String name;   // Audi 1, Audi 2

    private String theatreId;

    @NotNull(message = "Total rows required")
    private Integer totalRows;

    @NotNull(message = "Total columns required")
    private Integer totalColumns;

    private Integer totalSeats;

    private String screenType;  // IMAX, 3D, 4DX
}