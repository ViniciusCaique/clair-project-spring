package com.karma.clair.services;

import com.karma.clair.enums.WeaponType;
import com.karma.clair.models.weapon.Weapon;
import com.karma.clair.models.weapon.dtos.WeaponRequestDTO;
import com.karma.clair.models.weapon.dtos.WeaponResponseDTO;
import com.karma.clair.repositories.WeaponRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    @Cacheable("weapons")
    public List<WeaponResponseDTO> findAllWeaponByType(WeaponType weaponType) {
        var weapons = weaponRepository.findByWeaponType(weaponType).stream().map(w -> {
            WeaponResponseDTO weaponResponseDTO = new WeaponResponseDTO();
            BeanUtils.copyProperties(w, weaponResponseDTO);

            return weaponResponseDTO;
        }).toList();


        return weapons;
    }

    @Cacheable("weapons")
    public WeaponResponseDTO findByName(String name) {
        Weapon weapon = weaponRepository.findByName(name);

        WeaponResponseDTO weaponResponseDTO = new WeaponResponseDTO();
        BeanUtils.copyProperties(weapon, weaponResponseDTO);

        return weaponResponseDTO;
    }

    public WeaponResponseDTO create(WeaponRequestDTO weaponRequestDTO) {
        Weapon weapon = new Weapon();
        BeanUtils.copyProperties(weaponRequestDTO, weapon);

        var response = weaponRepository.save(weapon);

        WeaponResponseDTO weaponResponseDTO = new WeaponResponseDTO();
        BeanUtils.copyProperties(response, weaponResponseDTO);

        return weaponResponseDTO;
    }
}
