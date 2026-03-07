package com.movieticket.theatre.repository;

import com.movieticket.common.entity.theatre.ScreenLayout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenLayoutRepository extends JpaRepository<ScreenLayout, String> {

    void deleteByScreenId(String screenId);

    List<ScreenLayout> findByScreenId(String screenId);
}