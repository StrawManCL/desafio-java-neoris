package cl.neoris.desafio.service;

import cl.neoris.desafio.entity.AuthPost200Response;
import cl.neoris.desafio.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAllUsuarios();

    Optional<Usuario> findUsuarioById(Integer id);

    Void addUsuario(Usuario usuarios);

    Void updateUsuario(Integer id, Usuario usuarios);

    Void deleteUsuario(Integer id);

    AuthPost200Response login(UserDetails userDetails);
}
