package com.karma.clair.services;

import com.karma.clair.exceptions.EmailAlreadyRegisteredException;
import com.karma.clair.exceptions.NotFoundException;
import com.karma.clair.exceptions.UsernameAlreadyRegisteredException;
import com.karma.clair.models.auth.dtos.AuthRequestDTO;
import com.karma.clair.models.auth.dtos.AuthResponseDTO;
import com.karma.clair.models.users.User;
import com.karma.clair.models.users.dtos.UserRequestDTO;
import com.karma.clair.models.users.dtos.UserResponseDTO;
import com.karma.clair.repositories.UserRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    public final UserRepository userRepository;
    public final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDTO signIn(AuthRequestDTO authRequestDTO) {
        User user = new User();

        user.setEmail(authRequestDTO.identificator());
        user.setUsername(authRequestDTO.identificator());

        Optional<User> existingUser = userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername());

        if (existingUser.isEmpty()) {
            throw new NotFoundException();
        }

        var passwordMatches = passwordEncoder.matches(authRequestDTO.password(), existingUser.get().getPassword());
        if (!passwordMatches) {
            throw new NotFoundException();
        }

        AuthResponseDTO authResponseDTO = new AuthResponseDTO("token legal");

        return authResponseDTO;
    }

    public UserResponseDTO signUp(UserRequestDTO userRequestDTO) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDTO, user);

        Optional<User> existingUser = userRepository.findByEmailOrUsername(user.getEmail(), user.getUsername());

        if (existingUser.isPresent()) {
            if (existingUser.get().getEmail().equals(user.getEmail())) {
                throw new EmailAlreadyRegisteredException();
            } else {
                throw new UsernameAlreadyRegisteredException();
            }
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("MEMBER");

        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO(savedUser.getName(), savedUser.getEmail(), savedUser.getRole());

        return userResponseDTO;
    }
}
