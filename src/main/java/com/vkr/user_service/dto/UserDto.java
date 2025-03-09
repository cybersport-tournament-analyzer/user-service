package com.vkr.user_service.dto;

import com.vkr.user_service.entity.Role;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Builder
@Jacksonized
public record UserDto
        (
                UUID id,
                String steamId,
                String steamUsername,
                Long ratingElo,
                String avatarImageLink,
                String steamProfileLink,
                Role role
        ) {
}