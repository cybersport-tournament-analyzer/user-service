package com.vkr.user_service.controller;

import com.vkr.user_service.dto.CreateUserDto;
import com.vkr.user_service.dto.GetAverageRatingByIdsDto;
import com.vkr.user_service.dto.GetUsersByIdsDto;
import com.vkr.user_service.dto.UserDto;
import com.vkr.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all users")
    public Page<UserDto> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user by username")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/steam/{steamId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get user by steamId")
    public UserDto getUserBySteamId(@PathVariable String steamId) {
        return userService.getUserBySteamId(steamId);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete user")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Save user")
    public UserDto saveUser(@RequestBody CreateUserDto createUserDto) {
        return userService.saveUser(createUserDto);
    }

    @GetMapping("/byIds")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get list users by steamIds")
    public List<UserDto> getUsersBySteamIds(@RequestBody GetUsersByIdsDto dto) {
        return userService.getUsersByIds(dto.getIds());
    }

    @PostMapping("/averageEloRating")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get average elo rating by ids")
    public int getAverageRatingByIds(@RequestBody GetAverageRatingByIdsDto dto) {
        return userService.getAverageEloRating(dto.getIds(), dto.getPlayersNumber());
    }

}