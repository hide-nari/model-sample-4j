package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRecordTest {
    @Test
    public void personRecordModelTest() {
        var personOne = new PersonRecord();
        assertEquals("Mr.Taro", personOne.name());
        assertNotEquals("taro", personOne.name());
        assertNotEquals("Taro", personOne.name());
        assertEquals(15, personOne.age());

        var personTwo = new PersonRecord("jiro", 20);
        assertEquals("Mr.Jiro", personTwo.name());
        assertNotEquals("jiro", personTwo.name());
        assertNotEquals("Jiro", personTwo.name());
        assertEquals(20, personTwo.age());
        assertNotEquals(15, personTwo.age());
    }
}