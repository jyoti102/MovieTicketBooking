package com.movieticket.common.entity;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.enums.show.MovieStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String language;
    private String genre;
    private Integer durationMinutes;
    private String certificate;

    private LocalDate releaseDate;
    private String director;

    private Double rating;
    private String posterUrl;
    private String trailerUrl;

    @Enumerated(EnumType.STRING)
    private MovieStatus status;
}
