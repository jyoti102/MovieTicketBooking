package com.movieticket.theatre.repository;

import com.movieticket.common.entity.movie.Movie;
import com.movieticket.common.enums.show.MovieStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {

    Page<Movie> findByStatus(MovieStatus status, Pageable pageable);

}