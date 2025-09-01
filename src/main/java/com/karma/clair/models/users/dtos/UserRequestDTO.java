package com.karma.clair.models.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull String name,
        @NotNull String username,
        @NotNull @Email  String email,
        @NotNull String password
) {
}
