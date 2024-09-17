package cl.neoris.desafio.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PhoneTest {
    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertEquals(phone, phone2);
        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
        Phone phone = new Phone();
        phone.setCitycode(null);
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode(null);
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertEquals(phone, phone2);
        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode(null);
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode(null);
        phone2.setId(1L);
        phone2.setNumber("42");

        assertEquals(phone, phone2);
        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(null);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(null);
        phone2.setNumber("42");

        assertEquals(phone, phone2);
        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber(null);

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber(null);

        assertEquals(phone, phone2);
        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone2.hashCode());
    }

    @Test
    void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        int expectedHashCodeResult = phone.hashCode();
        assertEquals(expectedHashCodeResult, phone.hashCode());
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
        Phone phone = new Phone();
        phone.setCitycode("London");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
        Phone phone = new Phone();
        phone.setCitycode(null);
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GBR");
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode(null);
        phone.setId(1L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(2L);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(null);
        phone.setNumber("42");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("Oxford");

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber(null);

        Phone phone2 = new Phone();
        phone2.setCitycode("Oxford");
        phone2.setCountrycode("GB");
        phone2.setId(1L);
        phone2.setNumber("42");

        assertNotEquals(phone, phone2);
    }

    @Test
    void testEquals_whenOtherIsNull_thenReturnNotEqual() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        assertNotEquals(phone, null);
    }

    @Test
    void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
        Phone phone = new Phone();
        phone.setCitycode("Oxford");
        phone.setCountrycode("GB");
        phone.setId(1L);
        phone.setNumber("42");

        assertNotEquals(phone, "Objeto diferente a Phone");
    }

    @Test
    void testGettersAndSetters() {
        Phone actualPhone = new Phone();
        actualPhone.setCitycode("Oxford");
        actualPhone.setCountrycode("GB");
        actualPhone.setId(1L);
        actualPhone.setNumber("42");
        String actualToStringResult = actualPhone.toString();
        String actualCitycode = actualPhone.getCitycode();
        String actualCountrycode = actualPhone.getCountrycode();
        Long actualId = actualPhone.getId();

        assertEquals("42", actualPhone.getNumber());
        assertEquals("GB", actualCountrycode);
        assertEquals("Oxford", actualCitycode);
        assertEquals("Phone(id=1, number=42, citycode=Oxford, countrycode=GB)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
    }

    @Test
    void testGettersAndSetters2() {
        Phone actualPhone = new Phone(1L, "42", "Oxford", "GB");
        actualPhone.setCitycode("Oxford");
        actualPhone.setCountrycode("GB");
        actualPhone.setId(1L);
        actualPhone.setNumber("42");
        String actualToStringResult = actualPhone.toString();
        String actualCitycode = actualPhone.getCitycode();
        String actualCountrycode = actualPhone.getCountrycode();
        Long actualId = actualPhone.getId();

        assertEquals("42", actualPhone.getNumber());
        assertEquals("GB", actualCountrycode);
        assertEquals("Oxford", actualCitycode);
        assertEquals("Phone(id=1, number=42, citycode=Oxford, countrycode=GB)", actualToStringResult);
        assertEquals(1L, actualId.longValue());
    }
}
