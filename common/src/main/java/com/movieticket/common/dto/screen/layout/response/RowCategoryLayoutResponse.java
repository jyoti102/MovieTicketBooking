package com.movieticket.common.dto.screen.layout.response;

import com.movieticket.common.enums.theatre.SeatCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowCategoryLayoutResponse {

    private SeatCategory cat;

    private String seats;

    private String price;

}