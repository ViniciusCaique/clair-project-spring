package com.karma.clair.models.auth.dtos;

import lombok.Builder;

@Builder
public record AuthResponseDTO(
        String token
) {
}
