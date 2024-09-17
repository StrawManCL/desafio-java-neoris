package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.dto.PhoneDTO;
import cl.neoris.desafio.dto.UserFullResponseDTO;
import cl.neoris.desafio.dto.UserRequestDTO;
import cl.neoris.desafio.dto.UserResponseDTO;
import cl.neoris.desafio.exceptions.EmailAlreadyExistsException;
import cl.neoris.desafio.model.Phone;
import cl.neoris.desafio.model.User;
import cl.neoris.desafio.repository.UserRepository;
import cl.neoris.desafio.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserServiceImplTest {
    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testFindAllUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        List<UserResponseDTO> actualFindAllUsersResult = userServiceImpl.findAllUsers();

        verify(userRepository).findAll();
        assertTrue(actualFindAllUsersResult.isEmpty());
    }

    @Test
    void testFindAllUsers2() {
        User user = new User();
        user.setActive(true);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setCreated(created);
        user.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        user.setId(id);
        OffsetDateTime lastLogin = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setLastLogin(lastLogin);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setModified(modified);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);

        List<UserResponseDTO> actualFindAllUsersResult = userServiceImpl.findAllUsers();

        verify(userRepository).findAll();
        assertEquals(1, actualFindAllUsersResult.size());
        UserResponseDTO getResult = actualFindAllUsersResult.get(0);
        assertEquals("ABC123", getResult.token());
        assertEquals("Name", getResult.name());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertSame(created, getResult.created());
        assertSame(lastLogin, getResult.lastLogin());
        assertSame(modified, getResult.modified());
        assertSame(id, getResult.id());
    }

    @Test
    void testFindAllUsers3() {
        User user = new User();
        user.setActive(true);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setCreated(created);
        user.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        user.setId(id);
        OffsetDateTime lastLogin = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setLastLogin(lastLogin);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setModified(modified);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        User user2 = new User();
        user2.setActive(false);
        OffsetDateTime created2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user2.setCreated(created2);
        user2.setEmail("john.smith@example.org");
        UUID id2 = UUID.randomUUID();
        user2.setId(id2);
        OffsetDateTime lastLogin2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user2.setLastLogin(lastLogin2);
        OffsetDateTime modified2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user2.setModified(modified2);
        user2.setName("cl.neoris.desafio.model.User");
        user2.setPassword("Password");
        user2.setPhones(new ArrayList<>());
        user2.setToken("Token");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user2);
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);

        List<UserResponseDTO> actualFindAllUsersResult = userServiceImpl.findAllUsers();

        verify(userRepository).findAll();
        assertEquals(2, actualFindAllUsersResult.size());
        UserResponseDTO getResult = actualFindAllUsersResult.get(1);
        assertEquals("ABC123", getResult.token());
        assertEquals("Name", getResult.name());
        UserResponseDTO getResult2 = actualFindAllUsersResult.get(0);
        assertEquals("Token", getResult2.token());
        assertEquals("cl.neoris.desafio.model.User", getResult2.name());
        assertEquals("jane.doe@example.org", getResult.email());
        assertEquals("john.smith@example.org", getResult2.email());
        assertFalse(getResult2.isactive());
        assertTrue(getResult.isactive());
        assertSame(created2, getResult2.created());
        assertSame(created, getResult.created());
        assertSame(lastLogin2, getResult2.lastLogin());
        assertSame(lastLogin, getResult.lastLogin());
        assertSame(modified2, getResult2.modified());
        assertSame(modified, getResult.modified());
        assertSame(id2, getResult2.id());
        assertSame(id, getResult.id());
    }

    @Test
    void testFindAllUsers4() {
        when(userRepository.findAll()).thenThrow(new EmailAlreadyExistsException("An error occurred"));

        assertThrows(EmailAlreadyExistsException.class, () -> userServiceImpl.findAllUsers());
        verify(userRepository).findAll();
    }

    @Test
    void testFindAllUsers5() {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getName()).thenReturn("Name");
        when(user.getToken()).thenReturn("ABC123");
        OffsetDateTime ofResult = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getCreated()).thenReturn(ofResult);
        OffsetDateTime ofResult2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getLastLogin()).thenReturn(ofResult2);
        OffsetDateTime ofResult3 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getModified()).thenReturn(ofResult3);
        UUID randomUUIDResult = UUID.randomUUID();
        when(user.getId()).thenReturn(randomUUIDResult);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setCreated(Mockito.any());
        doNothing().when(user).setEmail(Mockito.any());
        doNothing().when(user).setId(Mockito.any());
        doNothing().when(user).setLastLogin(Mockito.any());
        doNothing().when(user).setModified(Mockito.any());
        doNothing().when(user).setName(Mockito.any());
        doNothing().when(user).setPassword(Mockito.any());
        doNothing().when(user).setPhones(Mockito.any());
        doNothing().when(user).setToken(Mockito.any());
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);

        List<UserResponseDTO> actualFindAllUsersResult = userServiceImpl.findAllUsers();

        verify(user).getCreated();
        verify(user).getEmail();
        verify(user).getId();
        verify(user).getLastLogin();
        verify(user).getModified();
        verify(user).getName();
        verify(user).getToken();
        verify(user).isActive();
        verify(user).setActive(eq(true));
        verify(user).setCreated(isA(OffsetDateTime.class));
        verify(user).setEmail(eq("jane.doe@example.org"));
        verify(user).setId(isA(UUID.class));
        verify(user).setLastLogin(isA(OffsetDateTime.class));
        verify(user).setModified(isA(OffsetDateTime.class));
        verify(user).setName(eq("Name"));
        verify(user).setPassword(eq("iloveyou"));
        verify(user).setPhones(isA(List.class));
        verify(user).setToken(eq("ABC123"));
        verify(userRepository).findAll();
        assertEquals(1, actualFindAllUsersResult.size());
        UserResponseDTO getResult = actualFindAllUsersResult.get(0);
        assertEquals("ABC123", getResult.token());
        assertEquals("Name", getResult.name());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertSame(ofResult, getResult.created());
        assertSame(ofResult2, getResult.lastLogin());
        assertSame(ofResult3, getResult.modified());
        assertSame(randomUUIDResult, getResult.id());
    }

    @Test
    void testFindUserById() {
        User user = new User();
        user.setActive(true);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setCreated(created);
        user.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        user.setId(id);
        OffsetDateTime lastLogin = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setLastLogin(lastLogin);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        user.setModified(modified);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.any())).thenReturn(ofResult);

        Optional<UserFullResponseDTO> actualFindUserByIdResult = userServiceImpl.findUserById(UUID.randomUUID());

        verify(userRepository).findById(isA(UUID.class));
        UserFullResponseDTO getResult = actualFindUserByIdResult.get();
        assertEquals("ABC123", getResult.token());
        assertEquals("Name", getResult.name());
        assertEquals("iloveyou", getResult.password());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertTrue(getResult.phones().isEmpty());
        assertTrue(actualFindUserByIdResult.isPresent());
        assertSame(created, getResult.created());
        assertSame(lastLogin, getResult.lastLogin());
        assertSame(modified, getResult.modified());
        assertSame(id, getResult.id());
    }

    @Test
    void testFindUserById2() {
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getToken()).thenReturn("ABC123");
        OffsetDateTime ofResult = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getCreated()).thenReturn(ofResult);
        OffsetDateTime ofResult2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getLastLogin()).thenReturn(ofResult2);
        OffsetDateTime ofResult3 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getModified()).thenReturn(ofResult3);
        when(user.getPhones()).thenReturn(new ArrayList<>());
        UUID randomUUIDResult = UUID.randomUUID();
        when(user.getId()).thenReturn(randomUUIDResult);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setCreated(Mockito.any());
        doNothing().when(user).setEmail(Mockito.any());
        doNothing().when(user).setId(Mockito.any());
        doNothing().when(user).setLastLogin(Mockito.any());
        doNothing().when(user).setModified(Mockito.any());
        doNothing().when(user).setName(Mockito.any());
        doNothing().when(user).setPassword(Mockito.any());
        doNothing().when(user).setPhones(Mockito.any());
        doNothing().when(user).setToken(Mockito.any());
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        Optional<User> ofResult4 = Optional.of(user);
        when(userRepository.findById(Mockito.any())).thenReturn(ofResult4);

        Optional<UserFullResponseDTO> actualFindUserByIdResult = userServiceImpl.findUserById(UUID.randomUUID());

        verify(user).getCreated();
        verify(user).getEmail();
        verify(user).getId();
        verify(user).getLastLogin();
        verify(user).getModified();
        verify(user).getName();
        verify(user).getPassword();
        verify(user).getPhones();
        verify(user).getToken();
        verify(user).isActive();
        verify(user).setActive(eq(true));
        verify(user).setCreated(isA(OffsetDateTime.class));
        verify(user).setEmail(eq("jane.doe@example.org"));
        verify(user).setId(isA(UUID.class));
        verify(user).setLastLogin(isA(OffsetDateTime.class));
        verify(user).setModified(isA(OffsetDateTime.class));
        verify(user).setName(eq("Name"));
        verify(user).setPassword(eq("iloveyou"));
        verify(user).setPhones(isA(List.class));
        verify(user).setToken(eq("ABC123"));
        verify(userRepository).findById(isA(UUID.class));
        UserFullResponseDTO getResult = actualFindUserByIdResult.get();
        assertEquals("ABC123", getResult.token());
        assertEquals("Name", getResult.name());
        assertEquals("iloveyou", getResult.password());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertTrue(getResult.phones().isEmpty());
        assertTrue(actualFindUserByIdResult.isPresent());
        assertSame(ofResult, getResult.created());
        assertSame(ofResult2, getResult.lastLogin());
        assertSame(ofResult3, getResult.modified());
        assertSame(randomUUIDResult, getResult.id());
    }

    @Test
    void testFindUserById3() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getToken()).thenReturn("ABC123");
        OffsetDateTime ofResult = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getCreated()).thenReturn(ofResult);
        OffsetDateTime ofResult2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getLastLogin()).thenReturn(ofResult2);
        OffsetDateTime ofResult3 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getModified()).thenReturn(ofResult3);
        when(user.getPhones()).thenReturn(phoneList);
        UUID randomUUIDResult = UUID.randomUUID();
        when(user.getId()).thenReturn(randomUUIDResult);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setCreated(Mockito.any());
        doNothing().when(user).setEmail(Mockito.any());
        doNothing().when(user).setId(Mockito.any());
        doNothing().when(user).setLastLogin(Mockito.any());
        doNothing().when(user).setModified(Mockito.any());
        doNothing().when(user).setName(Mockito.any());
        doNothing().when(user).setPassword(Mockito.any());
        doNothing().when(user).setPhones(Mockito.any());
        doNothing().when(user).setToken(Mockito.any());
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        Optional<User> ofResult4 = Optional.of(user);
        when(userRepository.findById(Mockito.any())).thenReturn(ofResult4);

        Optional<UserFullResponseDTO> actualFindUserByIdResult = userServiceImpl.findUserById(UUID.randomUUID());

        verify(user).getCreated();
        verify(user).getEmail();
        verify(user).getId();
        verify(user).getLastLogin();
        verify(user).getModified();
        verify(user).getName();
        verify(user).getPassword();
        verify(user).getPhones();
        verify(user).getToken();
        verify(user).isActive();
        verify(user).setActive(eq(true));
        verify(user).setCreated(isA(OffsetDateTime.class));
        verify(user).setEmail(eq("jane.doe@example.org"));
        verify(user).setId(isA(UUID.class));
        verify(user).setLastLogin(isA(OffsetDateTime.class));
        verify(user).setModified(isA(OffsetDateTime.class));
        verify(user).setName(eq("Name"));
        verify(user).setPassword(eq("iloveyou"));
        verify(user).setPhones(isA(List.class));
        verify(user).setToken(eq("ABC123"));
        verify(userRepository).findById(isA(UUID.class));
        UserFullResponseDTO getResult = actualFindUserByIdResult.get();
        List<PhoneDTO> phonesResult = getResult.phones();
        assertEquals(1, phonesResult.size());
        PhoneDTO getResult2 = phonesResult.get(0);
        assertEquals("42", getResult2.number());
        assertEquals("ABC123", getResult.token());
        assertEquals("GB", getResult2.countrycode());
        assertEquals("Name", getResult.name());
        assertEquals("Oxford", getResult2.citycode());
        assertEquals("iloveyou", getResult.password());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertTrue(actualFindUserByIdResult.isPresent());
        assertSame(ofResult, getResult.created());
        assertSame(ofResult2, getResult.lastLogin());
        assertSame(ofResult3, getResult.modified());
        assertSame(randomUUIDResult, getResult.id());
    }

    @Test
    void testFindUserById4() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("London");
        phone2.setCountrycode("GBR");
        phone2.setId(2L);
        phone2.setNumber("Number");

        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone2);
        phoneList.add(phone);
        User user = mock(User.class);
        when(user.isActive()).thenReturn(true);
        when(user.getEmail()).thenReturn("jane.doe@example.org");
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getToken()).thenReturn("ABC123");
        OffsetDateTime ofResult = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getCreated()).thenReturn(ofResult);
        OffsetDateTime ofResult2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getLastLogin()).thenReturn(ofResult2);
        OffsetDateTime ofResult3 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        when(user.getModified()).thenReturn(ofResult3);
        when(user.getPhones()).thenReturn(phoneList);
        UUID randomUUIDResult = UUID.randomUUID();
        when(user.getId()).thenReturn(randomUUIDResult);
        doNothing().when(user).setActive(anyBoolean());
        doNothing().when(user).setCreated(Mockito.any());
        doNothing().when(user).setEmail(Mockito.any());
        doNothing().when(user).setId(Mockito.any());
        doNothing().when(user).setLastLogin(Mockito.any());
        doNothing().when(user).setModified(Mockito.any());
        doNothing().when(user).setName(Mockito.any());
        doNothing().when(user).setPassword(Mockito.any());
        doNothing().when(user).setPhones(Mockito.any());
        doNothing().when(user).setToken(Mockito.any());
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        Optional<User> ofResult4 = Optional.of(user);
        when(userRepository.findById(Mockito.any())).thenReturn(ofResult4);

        Optional<UserFullResponseDTO> actualFindUserByIdResult = userServiceImpl.findUserById(UUID.randomUUID());

        verify(user).getCreated();
        verify(user).getEmail();
        verify(user).getId();
        verify(user).getLastLogin();
        verify(user).getModified();
        verify(user).getName();
        verify(user).getPassword();
        verify(user).getPhones();
        verify(user).getToken();
        verify(user).isActive();
        verify(user).setActive(eq(true));
        verify(user).setCreated(isA(OffsetDateTime.class));
        verify(user).setEmail(eq("jane.doe@example.org"));
        verify(user).setId(isA(UUID.class));
        verify(user).setLastLogin(isA(OffsetDateTime.class));
        verify(user).setModified(isA(OffsetDateTime.class));
        verify(user).setName(eq("Name"));
        verify(user).setPassword(eq("iloveyou"));
        verify(user).setPhones(isA(List.class));
        verify(user).setToken(eq("ABC123"));
        verify(userRepository).findById(isA(UUID.class));
        UserFullResponseDTO getResult = actualFindUserByIdResult.get();
        List<PhoneDTO> phonesResult = getResult.phones();
        assertEquals(2, phonesResult.size());
        PhoneDTO getResult2 = phonesResult.get(1);
        assertEquals("42", getResult2.number());
        assertEquals("ABC123", getResult.token());
        assertEquals("GB", getResult2.countrycode());
        PhoneDTO getResult3 = phonesResult.get(0);
        assertEquals("GBR", getResult3.countrycode());
        assertEquals("London", getResult3.citycode());
        assertEquals("Name", getResult.name());
        assertEquals("Number", getResult3.number());
        assertEquals("Oxford", getResult2.citycode());
        assertEquals("iloveyou", getResult.password());
        assertEquals("jane.doe@example.org", getResult.email());
        assertTrue(getResult.isactive());
        assertTrue(actualFindUserByIdResult.isPresent());
        assertSame(ofResult, getResult.created());
        assertSame(ofResult2, getResult.lastLogin());
        assertSame(ofResult3, getResult.modified());
        assertSame(randomUUIDResult, getResult.id());
    }

    @Test
    void testCreateUser() throws EmailAlreadyExistsException {
        when(userRepository.existsByEmail(Mockito.any())).thenReturn(true);

        assertThrows(EmailAlreadyExistsException.class, () -> userServiceImpl
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", new ArrayList<>())));
        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
    }

    @Test
    void testCreateUser2() throws EmailAlreadyExistsException {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        when(userRepository.existsByEmail(Mockito.any())).thenReturn(false);
        when(userRepository.save(Mockito.any())).thenReturn(user);
        when(jwtUtil.generateToken(Mockito.any())).thenReturn("ABC123");

        UserResponseDTO actualCreateUserResult = userServiceImpl
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", new ArrayList<>()));

        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
        verify(jwtUtil).generateToken(eq("jane.doe@example.org"));
        verify(userRepository).save(isA(User.class));
        assertEquals("ABC123", actualCreateUserResult.token());
        assertEquals("Name", actualCreateUserResult.name());
        assertEquals("jane.doe@example.org", actualCreateUserResult.email());
        assertTrue(actualCreateUserResult.isactive());
        ZoneOffset offset = actualCreateUserResult.created().getOffset();
        assertSame(offset, actualCreateUserResult.lastLogin().getOffset());
        assertSame(offset, actualCreateUserResult.modified().getOffset());
    }

    @Test
    void testCreateUser3() throws EmailAlreadyExistsException {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        when(userRepository.existsByEmail(Mockito.any())).thenReturn(false);
        when(userRepository.save(Mockito.any())).thenReturn(user);
        when(jwtUtil.generateToken(Mockito.any())).thenReturn("ABC123");

        ArrayList<PhoneDTO> phones = new ArrayList<>();
        phones.add(new PhoneDTO("42", "Oxford", "GB"));

        UserResponseDTO actualCreateUserResult = userServiceImpl
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", phones));

        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
        verify(jwtUtil).generateToken(eq("jane.doe@example.org"));
        verify(userRepository).save(isA(User.class));
        assertEquals("ABC123", actualCreateUserResult.token());
        assertEquals("Name", actualCreateUserResult.name());
        assertEquals("jane.doe@example.org", actualCreateUserResult.email());
        assertTrue(actualCreateUserResult.isactive());
        ZoneOffset offset = actualCreateUserResult.created().getOffset();
        assertSame(offset, actualCreateUserResult.lastLogin().getOffset());
        assertSame(offset, actualCreateUserResult.modified().getOffset());
    }

    @Test
    void testCreateUser4() throws EmailAlreadyExistsException {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");
        when(userRepository.existsByEmail(Mockito.any())).thenReturn(false);
        when(userRepository.save(Mockito.any())).thenReturn(user);
        when(jwtUtil.generateToken(Mockito.any())).thenReturn("ABC123");

        ArrayList<PhoneDTO> phones = new ArrayList<>();
        phones.add(new PhoneDTO("42", "Oxford", "GB"));
        phones.add(new PhoneDTO("42", "Oxford", "GB"));

        UserResponseDTO actualCreateUserResult = userServiceImpl
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", phones));

        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
        verify(jwtUtil).generateToken(eq("jane.doe@example.org"));
        verify(userRepository).save(isA(User.class));
        assertEquals("ABC123", actualCreateUserResult.token());
        assertEquals("Name", actualCreateUserResult.name());
        assertEquals("jane.doe@example.org", actualCreateUserResult.email());
        assertTrue(actualCreateUserResult.isactive());
        ZoneOffset offset = actualCreateUserResult.created().getOffset();
        assertSame(offset, actualCreateUserResult.lastLogin().getOffset());
        assertSame(offset, actualCreateUserResult.modified().getOffset());
    }

    @Test
    void testCreateUser5() throws EmailAlreadyExistsException {
        when(userRepository.existsByEmail(Mockito.any())).thenReturn(false);
        when(jwtUtil.generateToken(Mockito.any())).thenThrow(
                new EmailAlreadyExistsException("An error occurred"));

        assertThrows(EmailAlreadyExistsException.class, () -> userServiceImpl
                .createUser(new UserRequestDTO("Name", "jane.doe@example.org", "iloveyou", new ArrayList<>())));
        verify(userRepository).existsByEmail(eq("jane.doe@example.org"));
        verify(jwtUtil).generateToken(eq("jane.doe@example.org"));
    }
}
