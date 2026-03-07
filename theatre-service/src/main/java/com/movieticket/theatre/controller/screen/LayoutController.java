package com.movieticket.theatre.controller.screen;

import com.movieticket.common.dto.screen.layout.request.CreateLayoutRequest;
import com.movieticket.common.dto.screen.layout.response.LayoutResponse;
import com.movieticket.theatre.service.screen.LayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class LayoutController {

    private final LayoutService layoutService;

    @PostMapping("/screens/{screenId}/layouts")
    public LayoutResponse createLayout(@PathVariable String screenId,
                                       @RequestBody CreateLayoutRequest request) {

        return layoutService.createLayout(screenId, request);
    }

    @GetMapping("/screens/{screenId}/layouts")
    public LayoutResponse getLayout(@PathVariable String screenId) {

        return layoutService.getLayout(screenId);
    }

    @PutMapping("/screens/{screenId}/layouts")
    public LayoutResponse updateLayout(@PathVariable String screenId,
                                       @RequestBody CreateLayoutRequest request) {

        return layoutService.updateLayout(screenId, request);
    }

    @DeleteMapping("theatres/{theatreId}/screens/{screenId}/layouts")
    public void deleteLayout(@PathVariable String screenId) {

        layoutService.deleteLayout(screenId);
    }
}