package com.karma.clair.controllers;

import com.karma.clair.models.character.CharacterClair;
import com.karma.clair.models.character.dtos.CharacterRequestDTO;
import com.karma.clair.models.character.dtos.CharacterResponseDTO;
import com.karma.clair.services.CharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CharacterClair>> getAllCharacters() {
        var result = characterService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterClair> getCharacterById(@PathVariable UUID id) {
        var result = characterService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/")
    public ResponseEntity<CharacterResponseDTO> create(@RequestBody @Valid CharacterRequestDTO characterRequestDTO) {
        CharacterClair response = characterService.create(characterRequestDTO);

        CharacterResponseDTO characterResponseDTO = new CharacterResponseDTO();
        BeanUtils.copyProperties(response, characterResponseDTO);


        return ResponseEntity.status(HttpStatus.CREATED).body(characterResponseDTO);
    }
}
