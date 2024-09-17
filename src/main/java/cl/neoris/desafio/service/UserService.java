package cl.neoris.desafio.service;

import cl.neoris.desafio.dto.UserFullResponseDTO;
import cl.neoris.desafio.dto.UserRequestDTO;
import cl.neoris.desafio.dto.UserResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserResponseDTO> findAllUsers();

    Optional<UserFullResponseDTO> findUserById(UUID id);

    UserResponseDTO createUser(UserRequestDTO user);
}
