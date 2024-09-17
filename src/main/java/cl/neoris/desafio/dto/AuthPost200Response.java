package cl.neoris.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonTypeName("authPost_200_response")
public class AuthPost200Response {
    @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("token")
    private String token;
}
