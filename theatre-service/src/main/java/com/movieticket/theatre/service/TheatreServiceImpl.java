package com.movieticket.theatre.service;

import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.theatre.CreateTheatreRequest;
import com.movieticket.common.dto.theatre.TheatreResponse;
import com.movieticket.common.dto.theatre.UpdateTheatreRequest;
import com.movieticket.common.entity.theatre.Theatre;
import com.movieticket.common.mapper.theatre.TheatreMapper;
import com.movieticket.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService{

    public final TheatreMapper theatreMapper;
    public final TheatreRepository theatreRepo;

    @Override
    public TheatreResponse createTheatre(CreateTheatreRequest request) {
        Theatre theatre = theatreMapper.toEntity(request);
        theatreRepo.save(theatre);
        return theatreMapper.toResponse(theatre);
    }

    @Override
    public TheatreResponse updateTheatre(String theatreId, UpdateTheatreRequest request) {
        return null;
    }

    @Override
    public TheatreResponse getTheatreById(String theatreId) {
        Theatre theatre = theatreRepo.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        return theatreMapper.toResponse(theatre);
    }

    @Override
    public PageResponse<TheatreResponse> getAllTheatres(int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Theatre> theatrePage = theatreRepo.findAll(pageable);

        List<TheatreResponse> theatreResponses =
                theatreMapper.toResponseList(theatrePage.getContent());

        return PageResponse.<TheatreResponse>builder()
                .content(theatreResponses)
                .page(theatrePage.getNumber())
                .pageSize(theatrePage.getSize())
                .totalElements(theatrePage.getTotalElements())
                .totalPages(theatrePage.getTotalPages())
                .last(theatrePage.isLast())
                .build();
    }

    @Override
    public PageResponse<TheatreResponse> getTheatresByCity(String city, int page, int pageSize) {
        return null;
    }

    @Override
    public TheatreResponse updateTheatreStatus(String theatreId, String status) {
        return null;
    }

    @Override
    public PageResponse<TheatreResponse> getPublicTheatres(int page, int size) {
        return null;
    }
}
