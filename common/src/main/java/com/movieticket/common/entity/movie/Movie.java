package com.movieticket.common.entity.movie;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.entity.show.Show;
import com.movieticket.common.enums.show.MovieStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String posterUrl;

    private Integer durationMinutes;

    private String certificate; // U, UA, A

    private Double rating;

    private Integer votes;

    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private MovieStatus status;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;
}