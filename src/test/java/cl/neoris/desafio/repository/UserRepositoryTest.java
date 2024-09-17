package cl.neoris.desafio.repository;

import cl.neoris.desafio.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {UserRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"cl.neoris.desafio.model"})
@DataJpaTest
class UserRepositoryTest {
    private final UserRepository userRepository = mock(UserRepository.class);

    @Test
    void testFindByEmail() {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        User user2 = new User();
        user2.setActive(false);
        user2.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setEmail("john.smith@example.org");
        user2.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setName("cl.neoris.desafio.model.User");
        user2.setPassword("Password");
        user2.setPhones(new ArrayList<>());
        user2.setToken("Token");
        userRepository.save(user);
        userRepository.save(user2);

        userRepository.findByEmail("jane.doe@example.org");
    }

    @Test
    void testExistsByEmail() {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        User user2 = new User();
        user2.setActive(false);
        user2.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setEmail("john.smith@example.org");
        user2.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setName("cl.neoris.desafio.model.User");
        user2.setPassword("Password");
        user2.setPhones(new ArrayList<>());
        user2.setToken("Token");
        userRepository.save(user);
        userRepository.save(user2);

        userRepository.existsByEmail("jane.doe@example.org");
    }
}
