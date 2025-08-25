package com.karma.clair.controllers;

import com.karma.clair.enums.WeaponType;
import com.karma.clair.models.weapon.Weapon;
import com.karma.clair.models.weapon.dtos.WeaponRequestDTO;
import com.karma.clair.models.weapon.dtos.WeaponResponseDTO;
import com.karma.clair.services.CharacterService;
import com.karma.clair.services.WeaponService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/weapons")
public class WeaponController {

    private final WeaponService weaponService;

    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("")
    public ResponseEntity<List<WeaponResponseDTO>> findByWeaponType(@RequestParam("type") WeaponType weaponType) {
        var response = weaponService.findAllWeaponByType(weaponType);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<WeaponResponseDTO> findByName(@PathVariable("name") String name) {
        var response = weaponService.findByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/")
    public ResponseEntity<WeaponResponseDTO> create(@RequestBody @Valid WeaponRequestDTO weaponRequestDTO) {
        var response = weaponService.create(weaponRequestDTO);


        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
