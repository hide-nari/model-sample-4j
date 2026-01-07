package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void personModelTest() {
        var personOne = new Person();
        assertEquals("Mr.Taro", personOne.name);
        assertNotEquals("taro", personOne.name);
        assertNotEquals("Taro", personOne.name);
        assertEquals(15, personOne.age);

        personOne.name = "jiro";
        assertEquals("jiro", personOne.name);
        assertNotEquals("taro", personOne.name);

        personOne.age = 20;
        assertEquals(20, personOne.age);
        assertNotEquals(15, personOne.age);
    }

    @Test
    public void personModelWithParameterTest() {
        var personTwo = new Person("jiro", 20);
        assertEquals("Mr.Jiro", personTwo.name);
        assertNotEquals("jiro", personTwo.name);
        assertNotEquals("Jiro", personTwo.name);
        assertEquals(20, personTwo.age);
        assertNotEquals(15, personTwo.age);

        personTwo.name = "saburo";
        assertEquals("saburo", personTwo.name);
        assertNotEquals("jiro", personTwo.name);

        personTwo.age = 25;
        assertEquals(25, personTwo.age);
        assertNotEquals(20, personTwo.age);
    }
}