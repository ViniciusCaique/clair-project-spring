package com.karma.clair.models.users.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDTO(
        @NotNull String name,
        @NotNull String username,
        @NotNull String email
) {
}
