package com.movieticket.theatre.repository;

import com.movieticket.common.entity.show.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, String> {

    List<Show> findByTheatreId(String theatreId);

    List<Show> findByMovieId(String movieId);
}