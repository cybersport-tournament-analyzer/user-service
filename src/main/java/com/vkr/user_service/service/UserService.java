package com.vkr.user_service.service;

import com.vkr.user_service.dto.CreateUserDto;
import com.vkr.user_service.dto.UserDto;
import com.vkr.user_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    Page<UserDto> getAllUsers(Pageable pageable);

    UserDto getUserByUsername(String username);

    UserDto getUserBySteamId(String steamId);

    void deleteUser(String username);

    UserDto saveUser(CreateUserDto createUserDto);

    List<UserDto> getUsersByIds(List<String> steamIds);
}