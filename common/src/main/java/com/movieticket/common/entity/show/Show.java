package com.movieticket.common.entity.show;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.entity.movie.Movie;
import com.movieticket.common.entity.theatre.Theatre;
import com.movieticket.common.enums.show.ShowStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows",
       uniqueConstraints = {
           @UniqueConstraint(
               name = "unique_screen_show_time",
               columnNames = {"screen_id", "show_start_time"}
           )
       }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public class Show extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
    //
    //    @Column(name = "theatre_id", nullable = false)
    //    private String theatreId;

        @Column(name = "screen_id", nullable = false)
        private String screenId;
    //
    //    @Column(name = "movie_id", nullable = false)
    //    private String movieId;

        @Column(name = "show_start_time", nullable = false)
        private LocalDateTime showStartTime;

        @Column(name = "show_end_time", nullable = false)
        private LocalDateTime showEndTime;

        @Column(nullable = false)
        private String language;

        @Column(nullable = false)
        private String format; // 2D, 3D, IMAX etc.

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ShowStatus status;

        @ManyToOne
        @JoinColumn(name = "movie_id")
        private Movie movie;

        @ManyToOne
        @JoinColumn(name = "theatre_id")
        private Theatre theatre;
}