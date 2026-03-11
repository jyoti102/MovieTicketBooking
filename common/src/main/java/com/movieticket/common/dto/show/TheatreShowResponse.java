package com.movieticket.common.dto.show;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TheatreShowResponse {

    private String id;

    private String name;

    private String location;

    private boolean cancellable;

    private List<ShowResponse> shows;
}