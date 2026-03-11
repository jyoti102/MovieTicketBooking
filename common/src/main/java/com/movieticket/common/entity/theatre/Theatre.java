package com.movieticket.common.entity.theatre;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.entity.show.Show;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(
        name = "theatres",
        indexes = {
                @Index(name = "idx_theatre_city", columnList = "city")
        }
)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    private Integer totalScreens;

    private String address;
    private String city;
    private String state;
    private String pincode;

    private String locationUrl;

    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "theatre")
    private List<Show> shows;
}