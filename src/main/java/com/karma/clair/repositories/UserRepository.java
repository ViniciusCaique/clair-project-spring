package com.karma.clair.repositories;

import com.karma.clair.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailOrUsername(String email, String username);
}
