package com.movieticket.common.entity.user;

import com.movieticket.common.entity.common.BaseEntity;
import com.movieticket.common.enums.user.UserStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "keycloak_user_id", unique = true)
    private String keycloakUserId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String firstName;
    private String lastName;

    private String addressLine;
    private String city;
    private String pincode;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
