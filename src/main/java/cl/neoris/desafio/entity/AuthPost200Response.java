package cl.neoris.desafio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * AuthPost200Response
 */

@Data
@JsonTypeName("authPost_200_response")
public class AuthPost200Response {
    private String token;

    /**
     * Get token
     *
     * @return token
     */

    @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("token")
    public String getToken() {
        return token;
    }
}

