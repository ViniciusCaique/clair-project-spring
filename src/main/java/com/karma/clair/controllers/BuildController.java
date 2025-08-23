package com.karma.clair.controllers;


import com.karma.clair.models.build.Build;
import com.karma.clair.models.build.dtos.BuildRequestDTO;
import com.karma.clair.models.build.dtos.BuildResponseDTO;
import com.karma.clair.services.BuildService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/builds")
public class BuildController {

    private final BuildService buildService;

    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildResponseDTO> findById(@PathVariable UUID id) {
        BuildResponseDTO response = buildService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<BuildResponseDTO> findByCharacterId(@PathVariable UUID id) {
        BuildResponseDTO response = buildService.findByCharacterId(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<BuildResponseDTO> create(@RequestBody @Valid BuildRequestDTO buildRequestDTO) {
        var response = buildService.create(buildRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
