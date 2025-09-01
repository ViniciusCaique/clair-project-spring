package com.karma.clair.controllers;

import com.karma.clair.models.auth.dtos.AuthRequestDTO;
import com.karma.clair.models.auth.dtos.AuthResponseDTO;
import com.karma.clair.models.users.dtos.UserRequestDTO;
import com.karma.clair.models.users.dtos.UserResponseDTO;
import com.karma.clair.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponseDTO> signIn(@RequestBody @Valid AuthRequestDTO authRequestDTO) {
        AuthResponseDTO token = authService.signIn(authRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO user = authService.signUp(userRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
