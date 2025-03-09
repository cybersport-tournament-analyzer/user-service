package com.vkr.user_service.service;

import com.vkr.user_service.dto.UserDto;
import com.vkr.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {


    Page<UserDto> getAllUsers(Pageable pageable);

    UserDto getUserByUsername(String username);

    UserDto getUserBySteamId(String steamId);

    void deleteUser(String username);

    User getBySteamId(String steamId);
}