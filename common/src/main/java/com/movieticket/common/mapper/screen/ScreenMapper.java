package com.movieticket.common.mapper.screen;

import com.movieticket.common.dto.screen.CreateScreenRequest;
import com.movieticket.common.dto.screen.ScreenResponse;
import com.movieticket.common.entity.theatre.Screen;
import com.movieticket.common.entity.theatre.Theatre;
import com.movieticket.common.enums.theatre.ScreenType;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScreenMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(target = "screenType", expression = "java(mapScreenType(request.getScreenType()))")
    @Mapping(target = "theatre", expression = "java(mapTheatre(request.getTheatreId()))")
    Screen toEntity(CreateScreenRequest request);

    @Mapping(source = "theatre.id", target = "theatreId")
    ScreenResponse toResponse(Screen screen);

    List<ScreenResponse> toResponseList(List<Screen> screens);

    default ScreenType mapScreenType(String type) {
        if (type == null) return null;
        return ScreenType.valueOf(type.toUpperCase());
    }

    default Theatre mapTheatre(String theatreId) {
        if (theatreId == null) return null;

        Theatre theatre = new Theatre();
        theatre.setId(theatreId);
        return theatre;
    }
}