package cl.neoris.desafio.controller.impl;

import cl.neoris.desafio.controller.UserApi;
import cl.neoris.desafio.dto.UserFullResponseDTO;
import cl.neoris.desafio.dto.UserRequestDTO;
import cl.neoris.desafio.dto.UserResponseDTO;
import cl.neoris.desafio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserController implements UserApi {
    private final UserService userService;

    @Override
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> createUser(UserRequestDTO userRequestDTO) {
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @Override
    public ResponseEntity<UserFullResponseDTO> getUser(UUID id) {
        Optional<UserFullResponseDTO> optionalUsuario = userService.findUserById(id);
        return optionalUsuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
