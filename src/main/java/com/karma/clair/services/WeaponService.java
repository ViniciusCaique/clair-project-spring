package com.karma.clair.services;

import com.karma.clair.enums.WeaponType;
import com.karma.clair.models.weapon.Weapon;
import com.karma.clair.models.weapon.dtos.WeaponRequestDTO;
import com.karma.clair.repositories.WeaponRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    public List<Weapon> findAllWeaponByType(WeaponType weaponType) {
        List<Weapon> weapons = weaponRepository.findByWeaponType(weaponType);

        return weapons;
    }

    public Weapon findByName(String name) {
        Weapon weapon = weaponRepository.findByName(name);

        return weapon;
    }

    public Weapon create(WeaponRequestDTO weaponRequestDTO) {
        Weapon weapon = new Weapon();
        BeanUtils.copyProperties(weaponRequestDTO, weapon);

        var response = weaponRepository.save(weapon);

        return response;
    }
}
