package com.vkr.user_service.dto;

import com.vkr.user_service.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter
@Jacksonized
public class CreateUserDto {
    private String steamId;
    private String steamUsername;
    private Long ratingElo;
    private String avatarImageLink;
    private String steamProfileLink;
    private Role role;
}
