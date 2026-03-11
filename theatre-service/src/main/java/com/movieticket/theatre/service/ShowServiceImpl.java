package com.movieticket.theatre.service;

import com.movieticket.common.dto.show.CreateShowRequest;
import com.movieticket.common.dto.show.ShowResponse;
import com.movieticket.common.dto.show.TheatreShowResponse;
import com.movieticket.common.dto.show.UpdateShowRequest;
import com.movieticket.common.entity.movie.Movie;
import com.movieticket.common.entity.show.Show;
import com.movieticket.common.entity.theatre.Theatre;
import com.movieticket.common.mapper.ShowMapper;
import com.movieticket.common.mapper.theatre.TheatreMapper;
import com.movieticket.theatre.repository.MovieRepository;
import com.movieticket.theatre.repository.ShowRepository;
import com.movieticket.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowMapper showMapper;
    private final TheatreMapper theatreMapper;

    @Override
    public TheatreShowResponse createShow(CreateShowRequest request) {

        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found"));

        Show show = showMapper.toEntity(request);
        show.setMovie(movie);
        show.setTheatre(theatre);

        return theatreMapper.toShowResponse(theatre);
    }

    @Override
    public ShowResponse getShow(String id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        return showMapper.toResponse(show);
    }

    @Override
    public List<ShowResponse> getAllShows() {
        List<Show> showList = showRepository.findAll();
        return showMapper.toResponseList(showList);
    }

    @Override
    public ShowResponse updateShow(String id, UpdateShowRequest request) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
        show.setShowStartTime(request.getShowStartTime());
        show.setFormat(request.getFormat());

        showRepository.save(show);
        return showMapper.toResponse(show);
    }

    @Override
    public void deleteShow(String id) {
        showRepository.deleteById(id);
    }
}