package com.movieticket.common.entity.show;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.enums.theatre.SeatCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "show_pricing",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_show_seat_category",
                        columnNames = {"show_id", "seat_category"}
                )
        },
        indexes = {
                @Index(name = "idx_show_id", columnList = "show_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowPricing extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "show_id", nullable = false)
    private String showId;

    @Column(name = "screen_id", nullable = false)
    private String screenId;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_category", nullable = false)
    private SeatCategory seatCategory;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}