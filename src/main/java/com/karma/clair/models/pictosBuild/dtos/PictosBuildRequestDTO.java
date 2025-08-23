package com.karma.clair.models.pictosBuild.dtos;

import com.karma.clair.models.build.Build;
import com.karma.clair.models.pictos.Pictos;
import jakarta.validation.constraints.NotNull;

public record PictosBuildRequestDTO(
        @NotNull Build build,
        @NotNull Pictos pictos
        ) {
}
