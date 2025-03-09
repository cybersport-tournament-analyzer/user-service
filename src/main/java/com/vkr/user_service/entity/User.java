package com.vkr.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "steam_id", length = 64, unique = true, nullable = false)
    private String steamId;

    @Column(name = "steam_username", length = 64, nullable = false)
    private String steamUsername;

    @Column(name = "rating_elo", nullable = false)
    private Long ratingElo;

    @Column(name = "avatar_image_link", nullable = false)
    private String avatarImageLink;

    @Column(name = "steam_profile_link", nullable = false)
    private String steamProfileLink;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 64, nullable = false)
    private Role role;
}