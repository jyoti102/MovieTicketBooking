package com.movieticket.common.entity.theatre;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.enums.theatre.SeatCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "screen_layouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenLayout extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String screenId;

    @Column(nullable = false)
    private String rowName; // A, B, C, D

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatCategory category;

    /**
     * Columns where seats exist in this row.
     * Example: [5,6,7,8,13,14,15,16]
     * Missing columns represent aisle / walkway
     */
    @ElementCollection
    @CollectionTable(
            name = "screen_layout_seat_columns",
            joinColumns = @JoinColumn(name = "layout_id")
    )
    @Column(name = "seat_column")
    private List<Integer> seatColumns;
}