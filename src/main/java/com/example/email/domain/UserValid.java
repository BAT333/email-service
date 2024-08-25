package com.example.email.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "user_valid")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserValid {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod_valid",nullable = false,unique = true)
    private UUID uuid;
    @Column(name = "user",unique = true,nullable = false)
    private String user;
    @Column(name = "time_valid",nullable = false)
    private Instant instant;

    public UserValid(UUID uuid, String user, Instant instant) {
        this.uuid = uuid;
        this.user =user;
        this.instant = instant;
    }
}
