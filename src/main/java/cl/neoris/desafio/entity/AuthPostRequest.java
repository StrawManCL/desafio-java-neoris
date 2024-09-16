package cl.neoris.desafio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AuthPostRequest
 */
@Data
@JsonTypeName("authPost_request")
public class AuthPostRequest {

    private String username;

    private String password;

    /**
     * Get username
     *
     * @return username
     */
    @Schema(name = "username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     *
     * @return password
     */
    @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }
}

