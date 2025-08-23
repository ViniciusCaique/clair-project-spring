package com.karma.clair.models.build.dtos;

import com.karma.clair.models.character.CharacterClair;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BuildRequestDTO(
        @NotNull String name,
        String description,
        @NotNull UUID characterId,
        @NotNull UUID weaponId
        ) {
}
