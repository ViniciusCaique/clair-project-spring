package com.karma.clair.models.weapon.dtos;


import com.karma.clair.enums.WeaponType;
import com.karma.clair.models.build.Build;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponResponseDTO implements Serializable {
    private UUID id;
    private String name;
    private WeaponType weaponType;
    private Integer level;
}
