package cl.neoris.desafio.api;

import cl.neoris.desafio.entity.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Validated
@Tag(name = "Usuarios", description = "Funcionalidades de administración de usuarios.")
public interface UsuarioApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /usuarios : Crea un nuevo usuario
     *
     * @param usuarios (required)
     * @return Usuario creado (status code 201)
     */
    @Operation(
            operationId = "addUsuario",
            summary = "Crea un nuevo usuario",
            tags = {"Usuarios"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado")
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/usuarios",
            consumes = {"application/json"}
    )

    default ResponseEntity<Void> addUsuario(
            @Parameter(name = "Usuarios", description = "", required = true) @Valid @RequestBody Usuario usuarios
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /usuarios/{id} : Elimina un usuario
     *
     * @param id (required)
     * @return Usuario eliminado (status code 204)
     */
    @Operation(
            operationId = "deleteUsuario",
            summary = "Elimina un usuario",
            tags = {"Usuarios"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Usuario eliminado")
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/usuarios/{id}"
    )

    default ResponseEntity<Void> deleteUsuario(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id")
            Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /usuarios : Lista todos los usuarios
     *
     * @return Lista de usuarios (status code 200)
     */
    @Operation(
            operationId = "getAllUsuarios",
            summary = "Lista todos los usuarios",
            tags = {"Usuarios"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de usuarios", content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Usuario.class)))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/usuarios",
            produces = {"application/json"}
    )

    default ResponseEntity<List<Usuario>> getAllUsuarios(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString =
                            "[ { \"password\" : \"12345\", \"apellido\" : \"Cortinez\", \"correo\" : " +
                                    "\"marcelo@marcelo.com\", \"fechaCreacion\" : \"2024-03-15T12:30:00Z\", " +
                                    "\"fechaActualizacion\" : \"2024-03-15T12:30:00Z\", \"id\" : 15, \"nombre\" : " +
                                    "\"Marcelo\", \"username\" : \"marcelo15\" }, { \"password\" : \"12345\", " +
                                    "\"apellido\" : \"Cortinez\", \"correo\" : \"marcelo@marcelo.com\", " +
                                    "\"fechaCreacion\" : \"2024-03-15T12:30:00Z\", \"fechaActualizacion\" : " +
                                    "\"2024-03-15T12:30:00Z\", \"id\" : 15, \"nombre\" : \"Marcelo\", \"username\" : " +
                                    "\"marcelo15\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /usuarios/{id} : Obtiene los detalles de un usuario específico
     *
     * @param id (required)
     * @return Detalles del usuario (status code 200)
     */
    @Operation(
            operationId = "getUsuario",
            summary = "Obtiene los detalles de un usuario específico",
            tags = {"Usuarios"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalles del usuario", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/usuarios/{id}",
            produces = {"application/json"}
    )

    default ResponseEntity<Usuario> getUsuario(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id")
            Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString =
                            "{ \"password\" : \"12345\", \"apellido\" : \"Cortinez\", \"correo\" : \"marcelo@marcelo" +
                                    ".com\", \"fechaCreacion\" : \"2024-03-15T12:30:00Z\", \"fechaActualizacion\" : " +
                                    "\"2024-03-15T12:30:00Z\", \"id\" : 15, \"nombre\" : \"Marcelo\", \"username\" : " +
                                    "\"marcelo15\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /usuarios/{id} : Actualiza un usuario existente
     *
     * @param id       (required)
     * @param usuarios (required)
     * @return Usuario actualizado (status code 200)
     */
    @Operation(
            operationId = "updateUsuario",
            summary = "Actualiza un usuario existente",
            tags = {"Usuarios"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario actualizado")
            },
            security = {
                    @SecurityRequirement(name = "bearerAuth")
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/usuarios/{id}",
            consumes = {"application/json"}
    )

    default ResponseEntity<Void> updateUsuario(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id")
            Integer id,
            @Parameter(name = "Usuarios", description = "", required = true) @Valid @RequestBody Usuario usuarios
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
