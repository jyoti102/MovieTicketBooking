package com.movieticket.common.dto.screen.layout.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLayoutRequest {

    private List<RowLayoutRequest> rows;

}