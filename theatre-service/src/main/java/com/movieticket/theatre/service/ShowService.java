package com.movieticket.theatre.service;

import com.movieticket.common.dto.show.CreateShowRequest;
import com.movieticket.common.dto.show.ShowResponse;
import com.movieticket.common.dto.show.TheatreShowResponse;
import com.movieticket.common.dto.show.UpdateShowRequest;
import com.movieticket.common.entity.show.Show;

import java.util.List;

public interface ShowService {

    TheatreShowResponse createShow(CreateShowRequest request);

    ShowResponse getShow(String id);

    List<ShowResponse> getAllShows();

    ShowResponse updateShow(String id, UpdateShowRequest dto);

    void deleteShow(String id);
}