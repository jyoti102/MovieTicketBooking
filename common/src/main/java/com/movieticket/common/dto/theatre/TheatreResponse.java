package com.movieticket.common.dto.theatre;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreResponse {

    private String id;

    private String name;

    private Integer totalScreens;

    private String address;

    private String city;

    private String state;

    private String pincode;

    private String locationUrl;

    private Double latitude;

    private Double longitude;

}