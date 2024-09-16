package cl.neoris.desafio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * AuthPost200Response
 */

@JsonTypeName("authPost_200_response")
public class AuthPost200Response {

    private String token;

    public AuthPost200Response token(String token) {
        this.token = token;
        return this;
    }

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

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthPost200Response authPost200Response = (AuthPost200Response) o;
        return Objects.equals(this.token, authPost200Response.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthPost200Response {\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

