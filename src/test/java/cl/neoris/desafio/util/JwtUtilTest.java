package cl.neoris.desafio.util;

import cl.neoris.desafio.exceptions.InvalidTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.crypto.SecretKey;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {JwtUtil.class})
@ExtendWith(SpringExtension.class)
class JwtUtilTest {
    private static final String TOKEN_1 =
            "eyJhbGciOiJIUzI1NiJ9" +
                    ".eyJpc3MiOiJOZW9yaXMiLCJzdWIiOiJTYWx2YWRvci5BYmJvdHRAZ21haWwuY29tIiwiaWF0IjoxNzI2NTY0ODA2LCJleHAiOjE3MjY1NzU2MDZ9.T7by8fKtR_8-TtR4Pi2DdgJo1MmJtv-LCFCxctZPh8I";

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void testGenerateToken() {
        String token = jwtUtil.generateToken("User");

        assertNotNull(token);
    }

    @Test
    void testExtractExpiration() throws ExpiredJwtException {
        assertNull((new JwtUtil()).extractExpiration(TOKEN_1));
    }

    @Test
    void testExtractUsername() throws InvalidTokenException {
        assertNull((new JwtUtil()).extractUsername(TOKEN_1));
    }

    @Test
    void testExtractClaim() {
        assertNull((new JwtUtil()).extractClaim(TOKEN_1, mock(Function.class)));
    }
}
