package com.karma.clair.services;

import com.karma.clair.models.build.Build;
import com.karma.clair.models.build.dtos.BuildRequestDTO;
import com.karma.clair.models.build.dtos.BuildResponseDTO;
import com.karma.clair.models.character.CharacterClair;
import com.karma.clair.models.character.CharacterWithoutBuild;
import com.karma.clair.models.weapon.Weapon;
import com.karma.clair.models.weapon.WeaponWithoutBuild;
import com.karma.clair.repositories.BuildRepository;
import com.karma.clair.repositories.CharacterRepository;
import com.karma.clair.repositories.WeaponRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildService {

    private final BuildRepository buildRepository;
    private final CharacterRepository characterRepository;
    private final WeaponRepository weaponRepository;

    public BuildService(BuildRepository buildRepository, CharacterRepository characterRepository, WeaponRepository weaponRepository) {
        this.buildRepository = buildRepository;
        this.characterRepository = characterRepository;
        this.weaponRepository = weaponRepository;
    }

    @Cacheable("builds")
    public BuildResponseDTO findById(UUID id) {
        var response = buildRepository.findById(id).orElse(null);

        CharacterWithoutBuild c =  new CharacterWithoutBuild(
                response.getCharacter().getId(),
                response.getCharacter().getName(),
                response.getCharacter().getAge(),
                response.getCharacter().getRegion(),
                response.getCharacter().getGender(),
                response.getCharacter().getPhoto()
        );

        WeaponWithoutBuild w = new WeaponWithoutBuild(
                response.getWeapon().getId(),
                response.getWeapon().getName(),
                response.getWeapon().getWeaponType(),
                response.getWeapon().getLevel()
        );


        BuildResponseDTO responseDTO = new BuildResponseDTO();
        BeanUtils.copyProperties(response, responseDTO);

        responseDTO.setCharacter(c);
        responseDTO.setWeapon(w);

        return responseDTO;
    }

    @Cacheable("builds/character")
    public BuildResponseDTO findByCharacterId(UUID id) {
        var response = buildRepository.findByCharacterId(id).orElse(null);

        CharacterWithoutBuild c =  new CharacterWithoutBuild(
                response.getCharacter().getId(),
                response.getCharacter().getName(),
                response.getCharacter().getAge(),
                response.getCharacter().getRegion(),
                response.getCharacter().getGender(),
                response.getCharacter().getPhoto()
        );

        WeaponWithoutBuild w = new WeaponWithoutBuild(
                response.getWeapon().getId(),
                response.getWeapon().getName(),
                response.getWeapon().getWeaponType(),
                response.getWeapon().getLevel()
        );


        BuildResponseDTO responseDTO = new BuildResponseDTO();
        BeanUtils.copyProperties(response, responseDTO);

        responseDTO.setCharacter(c);
        responseDTO.setWeapon(w);

        return responseDTO;
    }

    public BuildResponseDTO create(BuildRequestDTO buildRequestDTO) {

        CharacterClair character = characterRepository.findById(buildRequestDTO.characterId()).orElse(null);
        Weapon weapon = weaponRepository.findById(buildRequestDTO.weaponId()).orElse(null);

        Build build = new Build();
        BeanUtils.copyProperties(buildRequestDTO, build);



        build.setCharacter(character);
        build.setWeapon(weapon);

        var response = buildRepository.save(build);
        BuildResponseDTO responseDTO = new BuildResponseDTO();

        BeanUtils.copyProperties(response, responseDTO);

        CharacterWithoutBuild c =  new CharacterWithoutBuild(
                response.getCharacter().getId(),
                response.getCharacter().getName(),
                response.getCharacter().getAge(),
                response.getCharacter().getRegion(),
                response.getCharacter().getGender(),
                response.getCharacter().getPhoto()
        );

        WeaponWithoutBuild w = new WeaponWithoutBuild(
                response.getWeapon().getId(),
                response.getWeapon().getName(),
                response.getWeapon().getWeaponType(),
                response.getWeapon().getLevel()
        );

        responseDTO.setCharacter(c);
        responseDTO.setWeapon(w);

        return responseDTO;
    }
}

