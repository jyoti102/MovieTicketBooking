package com.movieticket.theatre.repository;

import com.movieticket.common.entity.theatre.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String> {

    List<Theatre> findByCityIgnoreCase(String city);


}