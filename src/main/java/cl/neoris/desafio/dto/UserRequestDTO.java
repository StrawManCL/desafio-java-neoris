package cl.neoris.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record UserRequestDTO(
        @Schema(name = "name", example = "Juan Rodriguez", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        @JsonProperty("name")
        @NotBlank(message = "name - Nombre es obligatorio")
        String name,

        @Schema(name = "email", example = "juan@rodriguez.org", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("email")
        @Email(message = "email - Correo debe ser válido")
        String email,

        @Schema(name = "password", example = "hunter2", requiredMode = Schema.RequiredMode.REQUIRED)
        @JsonProperty("password")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$",
                message = "password - Contraseña debe contener al menos 8 caracteres, una mayúscula, una minúscula," +
                        " y un número")
        String password,

        @Schema(name = "phones", example = "[{\"number\": \"1234567\", \"citycode\": \"1\", \"countrycode\": \"57\"}]",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        @JsonProperty("phones")
        List<PhoneDTO> phones) {
}