package com.movieticket.theatre.repository;

import com.movieticket.common.entity.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}