package cl.neoris.desafio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;

/**
 * Usuarios
 */

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String correo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime fechaCreacion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime fechaActualizacion;

    /**
     * Get id
     *
     * @return id
     */

    @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "15",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Get username
     *
     * @return username
     */
    @Schema(name = "username", accessMode = Schema.AccessMode.READ_ONLY, example = "marcelo15",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     *
     * @return password
     */
    @Schema(name = "password", example = "12345", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Get nombre
     *
     * @return nombre
     */
    @Schema(name = "nombre", example = "Marcelo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * Get apellido
     *
     * @return apellido
     */
    @Schema(name = "apellido", example = "Cortinez", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("apellido")
    public String getApellido() {
        return apellido;
    }

    /**
     * Get correo
     *
     * @return correo
     */
    @Schema(name = "correo", example = "marcelo@marcelo.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("correo")
    public String getCorreo() {
        return correo;
    }

    /**
     * Get fechaCreacion
     *
     * @return fechaCreacion
     */
    @Valid
    @Schema(name = "fechaCreacion", example = "2024-03-15T12:30Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("fechaCreacion")
    public OffsetDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Get fechaActualizacion
     *
     * @return fechaActualizacion
     */
    @Valid
    @Schema(name = "fechaActualizacion", example = "2024-03-15T12:30Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("fechaActualizacion")
    public OffsetDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
}

