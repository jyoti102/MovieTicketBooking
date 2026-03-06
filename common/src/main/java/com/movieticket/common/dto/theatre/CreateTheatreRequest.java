package com.movieticket.common.dto.theatre;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTheatreRequest {

//    @NotBlank
    private String name;
    private Integer totalScreens;

//    @NotBlank
    private String city;

    private String address;
    private String state;
    private String pincode;

    private Double latitude;
    private Double longitude;
}