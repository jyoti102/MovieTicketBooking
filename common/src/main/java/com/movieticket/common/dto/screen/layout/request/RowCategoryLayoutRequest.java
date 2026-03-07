package com.movieticket.common.dto.screen.layout.request;

import com.movieticket.common.enums.theatre.SeatCategory;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowCategoryLayoutRequest {

    private SeatCategory cat;

    private List<Integer> seats;

}