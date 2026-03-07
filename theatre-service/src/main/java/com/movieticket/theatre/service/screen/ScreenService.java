package com.movieticket.theatre.service.screen;

import com.movieticket.common.dto.screen.CreateScreenRequest;
import com.movieticket.common.dto.screen.ScreenResponse;

import java.util.List;

public interface ScreenService {

    ScreenResponse createScreen(String theatreId, CreateScreenRequest request);

    List<ScreenResponse> getScreensByTheatre(String theatreId);

    ScreenResponse getScreenById(String screenId);

    ScreenResponse updateScreen(String screenId, CreateScreenRequest request);

    void deleteScreen(String screenId);
}
