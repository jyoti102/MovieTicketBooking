package com.movieticket.theatre.service.screen;


import com.movieticket.common.dto.screen.layout.request.CreateLayoutRequest;
import com.movieticket.common.dto.screen.layout.response.LayoutResponse;

public interface LayoutService {

    LayoutResponse createLayout(String screenId, CreateLayoutRequest request);

    LayoutResponse getLayout(String screenId);

    LayoutResponse updateLayout(String screenId, CreateLayoutRequest request);

    void deleteLayout(String screenId);

}