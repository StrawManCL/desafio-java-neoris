package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.model.User;
import cl.neoris.desafio.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MyUserDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MyUserDetailsServiceImplTest {
    @Autowired
    private MyUserDetailsServiceImpl myUserDetailsServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
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
        when(userRepository.findByEmail(Mockito.any())).thenReturn(user);

        UserDetails actualLoadUserByUsernameResult =
                myUserDetailsServiceImpl.loadUserByUsername("jane.doe@example.org");

        verify(userRepository).findByEmail(eq("jane.doe@example.org"));
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertInstanceOf(Set.class, authorities);
        assertInstanceOf(org.springframework.security.core.userdetails.User.class, actualLoadUserByUsernameResult);
        assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
        assertEquals("{noop}iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertTrue(authorities.isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
    }
}
