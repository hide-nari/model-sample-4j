package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonCapsuleTest {

    @Test
    public void personCapsuleModelTest() {
        var person = new PersonCapsule();
        assertEquals("Mr.Taro", person.getName());
        assertNotEquals("Mr.taro", person.getName());
        assertNotEquals("taro", person.getName());
        assertEquals(15, person.getAge());

        person.setName("jiro");
        assertEquals("Mr.Jiro", person.getName());
        assertNotEquals("jiro", person.getAge());

        person.setAge(20);
        assertEquals(20, person.getAge());
        assertNotEquals(15, person.getAge());
    }
}