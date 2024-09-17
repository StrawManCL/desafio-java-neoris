package cl.neoris.desafio.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConfigTest {
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        Config config = new Config();
        config.setId("42");
        config.setValor("Valor");

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor("Valor");

        assertEquals(config, config2);
        int expectedHashCodeResult = config.hashCode();
        assertEquals(expectedHashCodeResult, config2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
        Config config = new Config();
        config.setId(null);
        config.setValor("Valor");

        Config config2 = new Config();
        config2.setId(null);
        config2.setValor("Valor");

        assertEquals(config, config2);
        int expectedHashCodeResult = config.hashCode();
        assertEquals(expectedHashCodeResult, config2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
        Config config = new Config();
        config.setId("42");
        config.setValor(null);

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor(null);

        assertEquals(config, config2);
        int expectedHashCodeResult = config.hashCode();
        assertEquals(expectedHashCodeResult, config2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
        Config.ConfigBuilder configBuilder = mock(Config.ConfigBuilder.class);
        when(configBuilder.id(Mockito.any())).thenReturn(Config.builder());
        Config buildResult = configBuilder.id("42").valor("Valor").build();
        buildResult.setId("42");
        buildResult.setValor("Valor");

        Config config = new Config();
        config.setId("42");
        config.setValor("Valor");

        assertEquals(buildResult, config);
        int expectedHashCodeResult = buildResult.hashCode();
        assertEquals(expectedHashCodeResult, config.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        Config config = new Config();
        config.setId("42");
        config.setValor("Valor");

        int expectedHashCodeResult = config.hashCode();
        assertEquals(expectedHashCodeResult, config.hashCode());
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        Config config = new Config();
        config.setId("Valor");
        config.setValor("Valor");

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor("Valor");

        assertNotEquals(config, config2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        Config config = new Config();
        config.setId(null);
        config.setValor("Valor");

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor("Valor");

        assertNotEquals(config, config2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        Config config = new Config();
        config.setId("42");
        config.setValor("42");

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor("Valor");

        assertNotEquals(config, config2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        Config config = new Config();
        config.setId("42");
        config.setValor(null);

        Config config2 = new Config();
        config2.setId("42");
        config2.setValor("Valor");

        assertNotEquals(config, config2);
    }

    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        Config config = new Config();
        config.setId("42");
        config.setValor("Valor");

        assertNotEquals(config, null);
    }

    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        Config config = new Config();
        config.setId("42");
        config.setValor("Valor");

        assertNotEquals(config, "Objeto diferente a Config");
    }

    @Test
    void testGettersAndSetters() {
        Config actualConfig = new Config();
        actualConfig.setId("42");
        actualConfig.setValor("Valor");
        String actualToStringResult = actualConfig.toString();
        String actualId = actualConfig.getId();

        assertEquals("42", actualId);
        assertEquals("Config(id=42, valor=Valor)", actualToStringResult);
        assertEquals("Valor", actualConfig.getValor());
    }

    @Test
    void testGettersAndSetters2() {
        Config actualConfig = new Config("42", "Valor");
        actualConfig.setId("42");
        actualConfig.setValor("Valor");
        String actualToStringResult = actualConfig.toString();
        String actualId = actualConfig.getId();

        assertEquals("42", actualId);
        assertEquals("Config(id=42, valor=Valor)", actualToStringResult);
        assertEquals("Valor", actualConfig.getValor());
    }
}
