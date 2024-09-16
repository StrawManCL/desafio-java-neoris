package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.entity.Usuario;
import cl.neoris.desafio.repository.UsuarioRepository;
import cl.neoris.desafio.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    private final UsuarioRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuariosRepository.findByUsername(username);
        return new User(usuario.getUsername(),
                "{noop}" + usuario.getPassword(),
                Collections.emptyList());
    }
}
