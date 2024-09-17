package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.dto.PhoneDTO;
import cl.neoris.desafio.dto.UserFullResponseDTO;
import cl.neoris.desafio.dto.UserRequestDTO;
import cl.neoris.desafio.dto.UserResponseDTO;
import cl.neoris.desafio.exceptions.EmailAlreadyExistsException;
import cl.neoris.desafio.model.Phone;
import cl.neoris.desafio.model.User;
import cl.neoris.desafio.repository.UserRepository;
import cl.neoris.desafio.service.UserService;
import cl.neoris.desafio.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAll()
                .stream().map(UserResponseDTO::fromUser)
                .toList();
    }

    @Override
    public Optional<UserFullResponseDTO> findUserById(UUID id) {
        return userRepository.findById(id)
                .map(UserFullResponseDTO::fromUser);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws EmailAlreadyExistsException {
        if (userRepository.existsByEmail(userRequestDTO.email())) {
            throw new EmailAlreadyExistsException("El correo ya está registrado");
        }
        User user = User.builder()
                .id(UUID.randomUUID())
                .name(userRequestDTO.name())
                .email(userRequestDTO.email())
                .password(userRequestDTO.password())
                .phones(toPhones(userRequestDTO.phones()))
                .created(OffsetDateTime.now())
                .modified(OffsetDateTime.now())
                .lastLogin(OffsetDateTime.now())
                .token(generateToken(userRequestDTO.email()))
                .active(true)
                .build();
        userRepository.save(user);

        return UserResponseDTO.fromUser(user);
    }

    private List<Phone> toPhones(List<PhoneDTO> phones) {
        return phones.stream()
                .map(dto -> Phone.builder()
                        .number(dto.number())
                        .citycode(dto.citycode())
                        .countrycode(dto.countrycode())
                        .build())
                .toList();
    }

    private String generateToken(String email) {
        return jwtUtil.generateToken(email);
    }
}
