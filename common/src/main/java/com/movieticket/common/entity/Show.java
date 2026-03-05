package com.movieticket.common.entity;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.entity.theatre.Screen;
import com.movieticket.common.enums.show.ShowStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;

    private Double basePrice;

    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;
}