package com.karma.clair.models.weapon.dtos;


import com.karma.clair.enums.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponResponseDTO {
    private UUID id;
    private String name;
    private WeaponType weaponType;
    private Integer level;
}
