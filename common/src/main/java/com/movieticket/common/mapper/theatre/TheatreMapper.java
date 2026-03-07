package com.movieticket.common.mapper.theatre;

import com.movieticket.common.dto.theatre.CreateTheatreRequest;
import com.movieticket.common.dto.theatre.TheatreResponse;
import com.movieticket.common.dto.theatre.UpdateTheatreRequest;
import com.movieticket.common.entity.theatre.Theatre;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TheatreMapper {

    /**
     * Create Theatre Entity from Request
     */
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
    Theatre toEntity(CreateTheatreRequest request);


    /**
     * Entity → Response DTO
     */
    TheatreResponse toResponse(Theatre theatre);


    /**
     * List<Entity> → List<Response>
     */
    List<TheatreResponse> toResponseList(List<Theatre> theatres);


    /**
     * Update existing entity from request
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UpdateTheatreRequest request, @MappingTarget Theatre theatre);

//
//    /**
//     * Page<Entity> → PageResponse<Response>
//     */
//    default PageResponse<TheatreResponse> toPageResponse(Page<Theatre> page) {
//
//        PageResponse<TheatreResponse> response = new PageResponse<>();
//
//        response.setContent(toResponseList(page.getContent()));
//        response.setPage(page.getNumber());
//        response.setSize(page.getSize());
//        response.setTotalElements(page.getTotalElements());
//        response.setTotalPages(page.getTotalPages());
//
//        return response;
//    }
}