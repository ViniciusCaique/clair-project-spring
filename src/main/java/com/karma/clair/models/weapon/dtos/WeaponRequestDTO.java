package com.karma.clair.models.weapon.dtos;

import com.karma.clair.enums.WeaponType;
import jakarta.validation.constraints.NotNull;

public record WeaponRequestDTO (
        @NotNull String name,
        @NotNull WeaponType weaponType,
        @NotNull Integer level
) {
}
