package cl.neoris.desafio.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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

        User user2 = new User();
        user2.setActive(true);
        user2.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setEmail("jane.doe@example.org");
        user2.setId(UUID.randomUUID());
        user2.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhones(new ArrayList<>());
        user2.setToken("ABC123");

        assertNotEquals(user, user2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        User user = new User();
        user.setActive(false);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(UUID.randomUUID());
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        User user2 = new User();
        user2.setActive(true);
        user2.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setEmail("jane.doe@example.org");
        user2.setId(UUID.randomUUID());
        user2.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhones(new ArrayList<>());
        user2.setToken("ABC123");

        assertNotEquals(user, user2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        User user = new User();
        user.setActive(true);
        user.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setEmail("jane.doe@example.org");
        user.setId(null);
        user.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPhones(new ArrayList<>());
        user.setToken("ABC123");

        User user2 = new User();
        user2.setActive(true);
        user2.setCreated(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setEmail("jane.doe@example.org");
        user2.setId(UUID.randomUUID());
        user2.setLastLogin(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setModified(OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC));
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPhones(new ArrayList<>());
        user2.setToken("ABC123");

        assertNotEquals(user, user2);
    }

    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

        assertNotEquals(user, null);
    }

    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

        assertNotEquals(user, "Otro Objeto");
    }

    @Test
    void testGettersAndSetters() {
        User actualUser = new User();
        actualUser.setActive(true);
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setCreated(created);
        actualUser.setEmail("jane.doe@example.org");
        UUID id = UUID.randomUUID();
        actualUser.setId(id);
        OffsetDateTime lastLogin = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setLastLogin(lastLogin);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setModified(modified);
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        ArrayList<Phone> phones = new ArrayList<>();
        actualUser.setPhones(phones);
        actualUser.setToken("ABC123");
        OffsetDateTime actualCreated = actualUser.getCreated();
        String actualEmail = actualUser.getEmail();
        UUID actualId = actualUser.getId();
        OffsetDateTime actualLastLogin = actualUser.getLastLogin();
        OffsetDateTime actualModified = actualUser.getModified();
        String actualName = actualUser.getName();
        String actualPassword = actualUser.getPassword();
        List<Phone> actualPhones = actualUser.getPhones();
        String actualToken = actualUser.getToken();

        assertEquals("ABC123", actualToken);
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualEmail);
        assertTrue(actualUser.isActive());
        assertTrue(actualPhones.isEmpty());
        assertSame(phones, actualPhones);
        assertSame(created, actualCreated);
        assertSame(lastLogin, actualLastLogin);
        assertSame(modified, actualModified);
        assertSame(id, actualId);
    }

    @Test
    void testGettersAndSetters2() {
        UUID id = UUID.randomUUID();
        ArrayList<Phone> phones = new ArrayList<>();
        OffsetDateTime created = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        OffsetDateTime modified = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);

        User actualUser = new User(id, "Name", "jane.doe@example.org", "iloveyou", phones, created, modified,
                OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC), "ABC123", true);
        actualUser.setActive(true);
        OffsetDateTime created2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setCreated(created2);
        actualUser.setEmail("jane.doe@example.org");
        UUID id2 = UUID.randomUUID();
        actualUser.setId(id2);
        OffsetDateTime lastLogin = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setLastLogin(lastLogin);
        OffsetDateTime modified2 = OffsetDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIDNIGHT, ZoneOffset.UTC);
        actualUser.setModified(modified2);
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        ArrayList<Phone> phones2 = new ArrayList<>();
        actualUser.setPhones(phones2);
        actualUser.setToken("ABC123");
        OffsetDateTime actualCreated = actualUser.getCreated();
        String actualEmail = actualUser.getEmail();
        UUID actualId = actualUser.getId();
        OffsetDateTime actualLastLogin = actualUser.getLastLogin();
        OffsetDateTime actualModified = actualUser.getModified();
        String actualName = actualUser.getName();
        String actualPassword = actualUser.getPassword();
        List<Phone> actualPhones = actualUser.getPhones();
        String actualToken = actualUser.getToken();

        assertEquals("ABC123", actualToken);
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualPassword);
        assertEquals("jane.doe@example.org", actualEmail);
        assertTrue(actualUser.isActive());
        assertTrue(actualPhones.isEmpty());
        assertSame(phones2, actualPhones);
        assertSame(created2, actualCreated);
        assertSame(lastLogin, actualLastLogin);
        assertSame(modified2, actualModified);
        assertSame(id2, actualId);
    }
}
