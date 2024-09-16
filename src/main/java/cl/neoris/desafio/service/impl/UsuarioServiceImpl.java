package cl.neoris.desafio.service.impl;

import cl.neoris.desafio.entity.AuthPost200Response;
import cl.neoris.desafio.entity.Usuario;
import cl.neoris.desafio.repository.UsuarioRepository;
import cl.neoris.desafio.service.UsuarioService;
import cl.neoris.desafio.util.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Void addUsuario(Usuario usuario) {
        usuario.setFechaCreacion(OffsetDateTime.now());
        usuario.setFechaActualizacion(OffsetDateTime.now());
        usuarioRepository.save(usuario);
        return null;
    }

    @Override
    public Void updateUsuario(Integer id, Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuarioActual = optionalUsuario.get();
            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setApellido(usuario.getApellido());
            usuarioActual.setCorreo(usuario.getCorreo());
            usuarioActual.setPassword(usuario.getPassword());
            usuarioActual.setFechaActualizacion(OffsetDateTime.now());
            usuarioRepository.save(usuarioActual);
        } else {
            throw new EntityNotFoundException("Usuario no encontrado con ID: " + id);
        }
        return null;
    }

    @Override
    public Void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
        return null;
    }

    @Override
    public AuthPost200Response login(UserDetails userDetails) {
        AuthPost200Response authPost200Response = new AuthPost200Response();
        authPost200Response.setToken(jwtUtil.generateToken(userDetails));

        return authPost200Response;
    }
}
