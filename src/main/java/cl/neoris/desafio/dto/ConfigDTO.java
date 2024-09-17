package cl.neoris.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record ConfigDTO(
        @Schema(name = "id", accessMode = Schema.AccessMode.READ_ONLY, example = "regex_email",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        @JsonProperty("id")
        String id,

        @Schema(name = "value", example = ".*", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
        @JsonProperty("value")
        String value) {
}
