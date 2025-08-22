package com.karma.clair.repositories;

import com.karma.clair.models.character.CharacterClair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CharacterRepository extends JpaRepository<CharacterClair, UUID> {
}
