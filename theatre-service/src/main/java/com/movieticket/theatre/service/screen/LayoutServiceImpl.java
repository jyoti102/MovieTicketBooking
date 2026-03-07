package com.movieticket.theatre.service.screen;

import com.movieticket.common.dto.screen.layout.request.CreateLayoutRequest;
import com.movieticket.common.dto.screen.layout.response.LayoutResponse;
import com.movieticket.common.entity.theatre.ScreenLayout;
import com.movieticket.common.mapper.screen.LayoutMapper;
import com.movieticket.theatre.repository.ScreenLayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LayoutServiceImpl implements LayoutService {

    private final ScreenLayoutRepository layoutRepository;
    private final LayoutMapper layoutMapper;

    @Override
    public LayoutResponse createLayout(String screenId, CreateLayoutRequest request) {

        List<ScreenLayout> entities =
                layoutMapper.toEntities(request, screenId);

        layoutRepository.saveAll(entities);

        return layoutMapper.toResponse(entities, Map.of());
    }

    @Override
    public LayoutResponse getLayout(String screenId) {

        List<ScreenLayout> layouts =
                layoutRepository.findByScreenId(screenId);

        return layoutMapper.toResponse(layouts, Map.of());
    }

    @Override
    public LayoutResponse updateLayout(String screenId, CreateLayoutRequest request) {

        layoutRepository.deleteByScreenId(screenId);

        List<ScreenLayout> entities =
                layoutMapper.toEntities(request, screenId);

        layoutRepository.saveAll(entities);

        return layoutMapper.toResponse(entities, Map.of());
    }

    @Override
    public void deleteLayout(String screenId) {

        layoutRepository.deleteByScreenId(screenId);
    }
}