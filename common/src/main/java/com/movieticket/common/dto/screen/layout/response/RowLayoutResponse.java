package com.movieticket.common.dto.screen.layout.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowLayoutResponse {

    private String row;

    private boolean isAisle;

    private List<RowCategoryLayoutResponse> layout;

}