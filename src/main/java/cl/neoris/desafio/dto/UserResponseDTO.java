package cl.neoris.desafio.dto;

import cl.neoris.desafio.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.UUID;

public record UserResponseDTO(
        @Schema(name = "id", example = "d290f1ee-6c54-4b01-90e6-d701748f0851")
        @JsonProperty("id")
        UUID id,

        @Schema(name = "name", example = "Juan Rodriguez")
        @JsonProperty("name")
        String name,

        @Schema(name = "email", example = "juan@rodriguez.org")
        @JsonProperty("email")
        String email,

        @Schema(name = "created", example = "2024-09-16T12:30Z")
        @JsonProperty("created")
        OffsetDateTime created,

        @Schema(name = "modified", example = "2024-09-16T12:30Z")
        @JsonProperty("modified")
        OffsetDateTime modified,

        @Schema(name = "last_login", example = "2024-09-16T12:30Z")
        @JsonProperty("last_login")
        OffsetDateTime lastLogin,

        @Schema(name = "token", example = "abc123def456ghi789")
        @JsonProperty("token")
        String token,

        @Schema(name = "isactive", example = "true")
        @JsonProperty("isactive")
        boolean isactive) {

    public static UserResponseDTO fromUser(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreated(),
                user.getModified(),
                user.getLastLogin(),
                user.getToken(),
                user.isActive()
        );
    }
}
