package com.karma.clair.services;


import com.karma.clair.models.character.CharacterClair;
import com.karma.clair.models.character.dtos.CharacterRequestDTO;
import com.karma.clair.repositories.CharacterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterClair findById(UUID id) {
        var character = characterRepository.findById(id);

        return character.orElse(null);
    }

    public List<CharacterClair> findAll() {
        return characterRepository.findAll();
    }

    public CharacterClair create(CharacterRequestDTO characterRequestDTO) {
        CharacterClair character = new CharacterClair();
        BeanUtils.copyProperties(characterRequestDTO, character);

        CharacterClair result = characterRepository.save(character);

        return result;
    }
}
