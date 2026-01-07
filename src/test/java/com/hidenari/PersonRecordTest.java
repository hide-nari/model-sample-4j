package com.hidenari;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRecordTest {
    @Test
    public void personRecordModelTest() {
        var person = new PersonRecord("taro",15);
        assertEquals("taro", person.name());
        assertEquals(15, person.age());
    }
}