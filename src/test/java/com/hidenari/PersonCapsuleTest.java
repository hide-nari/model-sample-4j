package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonCapsuleTest {
    @Test
    public void personCapsuleModelTest() throws NoSuchFieldException {
        var person = new PersonCapsule();
        assertEquals("Mr.Taro", person.getName());
        assertNotEquals("Mr.taro", person.getName());
        assertNotEquals("taro", person.getName());
        assertEquals(15, person.getAge());

        person.setName("jiro");
        assertEquals("Mr.Jiro", person.getName());
        assertNotEquals("jiro", person.getName());

        person.setAge(20);
        assertEquals(20, person.getAge());
        assertNotEquals(15, person.getAge());
    }

    @Test
    public void personModelValidateUnderFifteenTest() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> new PersonCapsule("taro", 14));
        assertEquals("under 15", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMinLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> new PersonCapsule("壱", 15));
        assertEquals("name length is invalid", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMaxLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> new PersonCapsule("1234567890123456", 15));
        assertEquals("name length is invalid", exception.getMessage());
    }
}