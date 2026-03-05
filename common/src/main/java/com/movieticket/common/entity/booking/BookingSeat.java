package com.movieticket.common.entity.booking;

import com.movieticket.common.entity.theatre.Seat;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_seats")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;
}