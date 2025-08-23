package com.karma.clair.models.build.dtos;

import com.karma.clair.models.character.CharacterWithoutBuild;
import com.karma.clair.models.weapon.WeaponWithoutBuild;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private CharacterWithoutBuild character;
    private WeaponWithoutBuild weapon;
}
