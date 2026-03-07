package com.movieticket.theatre.service.screen;

import com.movieticket.common.dto.screen.CreateScreenRequest;
import com.movieticket.common.dto.screen.ScreenResponse;
import com.movieticket.common.entity.theatre.Screen;
import com.movieticket.common.entity.theatre.Theatre;
import com.movieticket.common.mapper.screen.ScreenMapper;
import com.movieticket.theatre.repository.ScreenRepository;
import com.movieticket.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final ScreenMapper screenMapper;
    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Override
    public ScreenResponse createScreen(String theatreId, CreateScreenRequest request) {

        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        Screen screen = Screen.builder()
                .name(request.getName())
                .totalRows(request.getTotalRows())
                .totalColumns(request.getTotalColumns())
                .theatre(theatre)
                .build();

        screen = screenRepository.save(screen);

        return screenMapper.toResponse(screen);
    }

    @Override
    public List<ScreenResponse> getScreensByTheatre(String theatreId) {

        List<Screen> screens = screenRepository.findByTheatreId(theatreId);

        return screenMapper.toResponseList(screens);
    }

    @Override
    public ScreenResponse getScreenById(String screenId) {

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        return screenMapper.toResponse(screen);
    }

    @Override
    public ScreenResponse updateScreen(String screenId, CreateScreenRequest request) {

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        screen.setName(request.getName());
        screen.setTotalRows(request.getTotalRows());
        screen.setTotalColumns(request.getTotalColumns());

        screen = screenRepository.save(screen);

        return screenMapper.toResponse(screen);
    }

    @Override
    public void deleteScreen(String screenId) {

        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found"));

        screenRepository.delete(screen);
    }

}