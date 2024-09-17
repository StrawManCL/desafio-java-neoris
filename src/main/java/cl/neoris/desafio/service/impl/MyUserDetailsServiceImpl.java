package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.model.User;
import cl.neoris.desafio.repository.UserRepository;
import cl.neoris.desafio.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    private final UserRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usuariosRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                "{noop}" + user.getPassword(),
                Collections.emptyList());
    }
}
