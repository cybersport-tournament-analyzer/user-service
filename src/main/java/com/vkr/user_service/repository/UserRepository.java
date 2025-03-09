package com.vkr.user_service.repository;

import com.vkr.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findBySteamUsername(String steamUsername);
    Optional<User> findBySteamId(String steamId);
}