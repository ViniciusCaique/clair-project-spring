package com.karma.clair.repositories;

import com.karma.clair.enums.WeaponType;
import com.karma.clair.models.weapon.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WeaponRepository extends JpaRepository<Weapon, UUID> {
    List<Weapon> findByWeaponType(WeaponType weaponType);
    Weapon findByName(String name);
}
