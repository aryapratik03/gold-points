package com.loyalty.gold_points_api.entities;

import jakarta.persistence.*;
import lombok.*;
import tools.jackson.databind.deser.bean.CreatorCandidate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_master")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 20, nullable = false)
    private String password;
}
