package com.movieticket.common.mapper.screen;

import com.movieticket.common.dto.screen.layout.request.CreateLayoutRequest;
import com.movieticket.common.dto.screen.layout.request.RowCategoryLayoutRequest;
import com.movieticket.common.dto.screen.layout.request.RowLayoutRequest;
import com.movieticket.common.dto.screen.layout.response.LayoutResponse;
import com.movieticket.common.dto.screen.layout.response.RowCategoryLayoutResponse;
import com.movieticket.common.dto.screen.layout.response.RowLayoutResponse;
import com.movieticket.common.entity.theatre.ScreenLayout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LayoutMapper {

    /*
     * Request -> Entity
     */

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "screenId", source = "screenId")
    @Mapping(target = "rowName", source = "row.row")
    @Mapping(target = "category", source = "category.cat")
    @Mapping(target = "seatColumns", source = "category.seats")
    ScreenLayout toEntity(RowLayoutRequest row,
                          RowCategoryLayoutRequest category,
                          String screenId);


    /*
     * Entity -> RowCategoryLayoutResponse
     */

    @Mapping(target = "cat", source = "category")
    @Mapping(target = "seats", expression = "java(joinSeats(layout.getSeatColumns()))")
    @Mapping(target = "price", ignore = true)
    RowCategoryLayoutResponse toCategoryResponse(ScreenLayout layout);


    /*
     * CreateLayoutRequest -> List<ScreenLayout>
     */

    default List<ScreenLayout> toEntities(CreateLayoutRequest request,
                                          String screenId) {

        List<ScreenLayout> result = new ArrayList<>();

        if (request == null || request.getRows() == null) {
            return result;
        }

        for (RowLayoutRequest row : request.getRows()) {

            if (row.getLayout() == null) continue;

            for (RowCategoryLayoutRequest category : row.getLayout()) {

                ScreenLayout entity = toEntity(row, category, screenId);
                result.add(entity);
            }
        }

        return result;
    }


    /*
     * Entity List -> LayoutResponse
     */

    default LayoutResponse toResponse(List<ScreenLayout> layouts,
                                      Map<String, String> priceMap) {

        if (layouts == null || layouts.isEmpty()) {
            return LayoutResponse.builder().rows(List.of()).build();
        }

        Map<String, List<ScreenLayout>> grouped =
                layouts.stream()
                        .collect(Collectors.groupingBy(ScreenLayout::getRowName));

        List<RowLayoutResponse> rows = new ArrayList<>();

        for (Map.Entry<String, List<ScreenLayout>> entry : grouped.entrySet()) {

            String rowName = entry.getKey();
            List<ScreenLayout> rowLayouts = entry.getValue();

            List<RowCategoryLayoutResponse> categories =
                    rowLayouts.stream()
                            .map(layout -> {

                                RowCategoryLayoutResponse response =
                                        toCategoryResponse(layout);

                                if (priceMap != null) {
                                    response.setPrice(
                                            priceMap.getOrDefault(
                                                    layout.getCategory().name(),
                                                    null
                                            )
                                    );
                                }

                                return response;

                            })
                            .toList();

            RowLayoutResponse rowResponse =
                    RowLayoutResponse.builder()
                            .row(rowName)
                            .isAisle(false)
                            .layout(categories)
                            .build();

            rows.add(rowResponse);
        }

        return LayoutResponse.builder()
                .rows(rows)
                .build();
    }


    /*
     * Utility
     */

    default String joinSeats(List<Integer> seats) {

        if (seats == null || seats.isEmpty()) {
            return "";
        }

        return seats.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}