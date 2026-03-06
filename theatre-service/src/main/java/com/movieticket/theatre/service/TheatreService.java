package com.movieticket.theatre.service;

import com.movieticket.common.dto.common.PageResponse;
import com.movieticket.common.dto.theatre.CreateTheatreRequest;
import com.movieticket.common.dto.theatre.UpdateTheatreRequest;
import com.movieticket.common.dto.theatre.TheatreResponse;


public interface TheatreService {

    TheatreResponse createTheatre(CreateTheatreRequest request);

    TheatreResponse updateTheatre(String theatreId, UpdateTheatreRequest request);

    TheatreResponse getTheatreById(String theatreId);

    PageResponse<TheatreResponse> getAllTheatres(int page, int pageSize);

    PageResponse<TheatreResponse> getTheatresByCity(String city, int page, int pageSize);

    TheatreResponse updateTheatreStatus(String theatreId, String status);

    PageResponse<TheatreResponse> getPublicTheatres(int page, int size);
}