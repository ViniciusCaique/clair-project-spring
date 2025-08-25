package com.karma.clair.models.weapon;

import com.karma.clair.enums.Gender;
import com.karma.clair.enums.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponWithoutBuild implements Serializable {
    private UUID id;
    private String name;
    private WeaponType weaponType;
    private Integer level;
}
