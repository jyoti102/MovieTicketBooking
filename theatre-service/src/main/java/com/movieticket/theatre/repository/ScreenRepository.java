package com.movieticket.theatre.repository;

import com.movieticket.common.entity.theatre.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, String> {

    List<Screen> findByTheatreId(String theatreId);

}