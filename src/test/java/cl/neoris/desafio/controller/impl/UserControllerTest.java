package cl.neoris.desafio.controller.impl;

import cl.neoris.desafio.dto.UserRequestDTO;
import cl.neoris.desafio.dto.UserResponseDTO;
import cl.neoris.desafio.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @Test
    void testCreateUser() {
        UUID id = UUID.randomUUID();
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        UserResponseDTO userResponseDTO = new UserResponseDTO(id, "Name", "jane.doe@example.org", created, modified,
                OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC), "ABC123", true);

        when(userService.createUser(Mockito.any())).thenReturn(userResponseDTO);

        ResponseEntity<?> actualCreateUserResult = userController
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", new ArrayList<>()));

        verify(userService).createUser(isA(UserRequestDTO.class));
        HttpStatusCode statusCode = actualCreateUserResult.getStatusCode();
        assertInstanceOf(HttpStatus.class, statusCode);
        assertEquals(201, actualCreateUserResult.getStatusCode().value());
        assertEquals(HttpStatus.CREATED, statusCode);
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
        assertSame(userResponseDTO, actualCreateUserResult.getBody());
    }
}
