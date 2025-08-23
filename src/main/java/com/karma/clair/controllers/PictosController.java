package com.karma.clair.controllers;

import com.karma.clair.enums.PictosAttribute;
import com.karma.clair.models.pictos.Pictos;
import com.karma.clair.models.pictos.dtos.PictosRequestDTO;
import com.karma.clair.models.pictos.dtos.PictosResponseDTO;
import com.karma.clair.services.PictosService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pictos")
public class PictosController {

    private final PictosService pictosService;

    public PictosController(PictosService pictosService) {
        this.pictosService = pictosService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Pictos>> findAll() {
        var response = pictosService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<PictosResponseDTO> create(@RequestBody @Valid PictosRequestDTO pictosRequestDTO) {
        var response = pictosService.create(pictosRequestDTO);
        PictosResponseDTO pictosResponseDTO = new PictosResponseDTO();

        BeanUtils.copyProperties(response, pictosResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pictosResponseDTO);
    }
}
