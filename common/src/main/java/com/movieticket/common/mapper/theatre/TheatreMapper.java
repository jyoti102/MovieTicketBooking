package com.movieticket.common.mapper.theatre;

import com.movieticket.common.dto.theatre.*;
import com.movieticket.common.entity.theatre.Theatre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TheatreMapper {

    Theatre toEntity(CreateTheatreRequest request);

    TheatreResponse toResponse(Theatre theatre);

    List<TheatreResponse> toResponseList(List<Theatre> theatres);

}