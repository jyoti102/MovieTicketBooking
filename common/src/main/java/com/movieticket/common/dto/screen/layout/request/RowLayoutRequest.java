package com.movieticket.common.dto.screen.layout.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowLayoutRequest {

    private String row;          // A, B, C

    private Boolean isAisleNext; // walkway after row

    private List<RowCategoryLayoutRequest> layout;

}