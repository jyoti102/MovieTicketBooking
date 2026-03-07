package com.movieticket.common.dto.screen.layout.response;

import com.movieticket.common.dto.screen.layout.request.RowLayoutRequest;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayoutResponse {
    private List<RowLayoutResponse> rows;
}
