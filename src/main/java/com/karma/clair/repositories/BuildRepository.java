package com.karma.clair.repositories;

import com.karma.clair.models.build.Build;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BuildRepository extends JpaRepository<Build, UUID> {
    Optional<Build> findByCharacterId(UUID id);
}
