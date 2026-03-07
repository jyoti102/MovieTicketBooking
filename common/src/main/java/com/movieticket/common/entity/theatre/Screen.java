package com.movieticket.common.entity.theatre;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.enums.theatre.ScreenType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "screens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;   // Screen 1, Screen 2

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    private Integer totalRows;

    private Integer totalColumns;

    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
}