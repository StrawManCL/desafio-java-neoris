package cl.neoris.desafio.controller;

import cl.neoris.desafio.api.UsuarioApi;
import cl.neoris.desafio.entity.Usuario;
import cl.neoris.desafio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController implements UsuarioApi {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Adds a new usuario to the system.
     *
     * @param usuarios the usuario object to be added
     * @return the response entity containing the result of the operation
     */
    @Override
    public ResponseEntity<Void> addUsuario(Usuario usuarios) {
        return ResponseEntity.ok(usuarioService.addUsuario(usuarios));
    }

    /**
     * Deletes a usuario by the given id.
     *
     * @param id the id of the usuario to be deleted
     * @return the ResponseEntity with a status of OK and the result of deleting the usuario
     */
    @Override
    public ResponseEntity<Void> deleteUsuario(Integer id) {
        return ResponseEntity.ok(usuarioService.deleteUsuario(id));
    }

    /**
     * Retrieves all usuarios.
     *
     * @return Response entity with the list of usuarios
     */
    @Override
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the ResponseEntity containing the user if found, or not found if not found
     */
    @Override
    public ResponseEntity<Usuario> getUsuario(Integer id) {
        Optional<Usuario> optionalUsuario = usuarioService.findUsuarioById(id);
        return optionalUsuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates a Usuario.
     *
     * @param id       the ID of the Usuario to update
     * @param usuarios the updated Usuario object
     * @return the ResponseEntity containing the updated Usuario
     */
    @Override
    public ResponseEntity<Void> updateUsuario(Integer id, Usuario usuarios) {
        return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarios));
    }
}
