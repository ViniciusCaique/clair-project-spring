package com.karma.clair.services;


import com.karma.clair.models.character.CharacterClair;
import com.karma.clair.models.character.dtos.CharacterRequestDTO;
import com.karma.clair.models.character.dtos.CharacterResponseDTO;
import com.karma.clair.repositories.CharacterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Cacheable("character")
    public CharacterResponseDTO findById(UUID id) {
        var character = characterRepository.findById(id).orElse(null);

        CharacterResponseDTO characterResponseDTO = new CharacterResponseDTO();

        BeanUtils.copyProperties(character, characterResponseDTO);

        return characterResponseDTO;
    }

    @Cacheable("characters")
    public List<CharacterResponseDTO> findAll() {

        var characters = characterRepository.findAll().stream().map(c -> {
        CharacterResponseDTO characterResponseDTO = new CharacterResponseDTO();

        BeanUtils.copyProperties(c, characterResponseDTO);
        return characterResponseDTO;
        }).toList();

        return characters;
    }

    public CharacterResponseDTO create(CharacterRequestDTO characterRequestDTO) {
        CharacterClair character = new CharacterClair();
        BeanUtils.copyProperties(characterRequestDTO, character);

        CharacterClair result = characterRepository.save(character);

        CharacterResponseDTO characterResponseDTO = new CharacterResponseDTO();

        BeanUtils.copyProperties(result, characterResponseDTO);

        return characterResponseDTO;
    }
}
