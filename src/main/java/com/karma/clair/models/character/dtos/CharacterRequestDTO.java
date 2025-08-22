package com.karma.clair.models.character.dtos;

import com.karma.clair.enums.Gender;
import jakarta.validation.constraints.NotNull;

public record CharacterRequestDTO (
        @NotNull String name,
        @NotNull Integer age,
        @NotNull String region,
        @NotNull Gender gender,
        String Photo
) {
}
