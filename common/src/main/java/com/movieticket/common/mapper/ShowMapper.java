package com.movieticket.common.mapper;

import com.movieticket.common.dto.show.CreateShowRequest;
import com.movieticket.common.dto.show.ShowResponse;
import com.movieticket.common.entity.show.Show;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowMapper {

    @Mapping(source = "showStartTime", target = "showStartTime")
    @Mapping(source = "showEndTime", target = "showEndTime")
    ShowResponse toResponse(Show show);

    List<ShowResponse> toResponseList(List<Show> shows);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "movie", ignore = true)
    @Mapping(target = "theatre", ignore = true)
    Show toEntity(CreateShowRequest request);
}