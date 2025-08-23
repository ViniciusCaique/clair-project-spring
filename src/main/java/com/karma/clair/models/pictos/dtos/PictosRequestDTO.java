package com.karma.clair.models.pictos.dtos;

import com.karma.clair.enums.PictosAttribute;
import jakarta.validation.constraints.NotNull;

public record PictosRequestDTO(
        @NotNull String name,
        @NotNull String description,
        @NotNull PictosAttribute attribute,
        @NotNull Integer level
        ) {
}
