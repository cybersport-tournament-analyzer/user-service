package com.vkr.user_service.service;

import com.vkr.user_service.dto.CreateUserDto;
import com.vkr.user_service.dto.UserDto;
import com.vkr.user_service.entity.User;
import com.vkr.user_service.exception.UserNotFoundException;
import com.vkr.user_service.mapper.UserMapper;
import com.vkr.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserByUsername(String username) {
        User user = findUserByUsername(username);

        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserBySteamId(String steamId) {
        return userRepository.findBySteamId(steamId).map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("steamId", steamId));
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        User user = findUserByUsername(username);

        userRepository.delete(user);

        log.info("User deleted: {}", user);
    }

    private User findUserByUsername(String username) {
        return userRepository.findBySteamUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public UserDto saveUser(CreateUserDto createUserDto) {
        User user;

        if(userRepository.findBySteamId(createUserDto.getSteamId()).isPresent()) {
            user = userRepository.findBySteamId(createUserDto.getSteamId()).get();
            userMapper.updateEntity(user, createUserDto);
        } else {
            user = userMapper.toEntity(createUserDto);
        }

        log.info("Saving user: {}", user);

        return userMapper.toDto(userRepository.save(user));
    }
}
