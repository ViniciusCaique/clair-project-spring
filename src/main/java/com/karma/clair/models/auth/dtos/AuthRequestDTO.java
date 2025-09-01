package com.karma.clair.models.auth.dtos;

import jakarta.validation.constraints.NotNull;

public record AuthRequestDTO(
        @NotNull String identificator,
        @NotNull String password
) {
}
