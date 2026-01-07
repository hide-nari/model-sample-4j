package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personModelTest() {
        var person = new Person();
        assertEquals("Mr.Taro", person.name);
        assertNotEquals("taro", person.name);
        assertNotEquals("Taro", person.name);
        assertEquals(15, person.age);

        person.name = "jiro";
        assertEquals("jiro", person.name);
        assertNotEquals("taro", person.name);

        person.age = 20;
        assertEquals(20, person.age);
        assertNotEquals(15, person.age);
    }
}