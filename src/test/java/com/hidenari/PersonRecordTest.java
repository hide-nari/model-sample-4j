package com.hidenari;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Record Model Test")
class PersonRecordTest {
    @Test
    @DisplayName("Person Record Model")
    void personRecordModelTest() {
        var personOne = new PersonRecord();
        assertEquals("Mr.Taro", personOne.name());
        assertNotEquals("taro", personOne.name());
        assertNotEquals("Taro", personOne.name());
        assertEquals(15, personOne.age());
        assertEquals(GradeEnum.BRONZE, personOne.grade());

        var personTwo = new PersonRecord("jiro", 20, GradeEnum.BRONZE);
        assertEquals("Mr.Jiro", personTwo.name());
        assertNotEquals("jiro", personTwo.name());
        assertNotEquals("Jiro", personTwo.name());
        assertEquals(20, personTwo.age());
        assertNotEquals(15, personTwo.age());
        assertEquals(GradeEnum.BRONZE, personTwo.grade());
    }

    @Test
    @DisplayName("Person Record Model Validate Under Fifteen")
    void personModelValidateUnderFifteenTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonRecord("taro", 14, GradeEnum.BRONZE));
        assertEquals("under 15", exception.getMessage());
    }

    @Test
    @DisplayName("Person Record Model Validate Name Min Length Over")
    void personModelValidateNameMinLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonRecord("壱", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }

    @Test
    @DisplayName("Person Record Model Validate Name Max Length Over")
    void personModelValidateNameMaxLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonRecord("1234567890123456", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }
}