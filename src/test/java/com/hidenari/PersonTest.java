package com.hidenari;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Model Test")
class PersonTest {
    @Test
    @DisplayName("Person Model")
    void personModelTest() {
        var personOne = new Person();
        assertEquals("Mr.Taro", personOne.name);
        assertNotEquals("taro", personOne.name);
        assertNotEquals("Taro", personOne.name);
        assertEquals(15, personOne.age);
        assertEquals(GradeEnum.BRONZE, personOne.grade);

        personOne.name = "jiro";
        assertEquals("jiro", personOne.name);
        assertNotEquals("taro", personOne.name);

        personOne.age = 20;
        assertEquals(20, personOne.age);
        assertNotEquals(15, personOne.age);

        personOne.grade = GradeEnum.SILVER;
        assertEquals(GradeEnum.SILVER, personOne.grade);
        assertNotEquals(GradeEnum.BRONZE, personOne.grade);

        personOne.grade = GradeEnum.GOLD;
        assertEquals(GradeEnum.GOLD, personOne.grade);
        assertNotEquals(GradeEnum.BRONZE, personOne.grade);
        assertNotEquals(GradeEnum.SILVER, personOne.grade);
    }

    @Test
    @DisplayName("Person Model Enum Function")
    void personModelEnumFunctionTest() {
        var person = new Person();
        person.grade = person.grade.upGrade(person.grade);
        assertEquals(GradeEnum.SILVER, person.grade);
        person.grade = person.grade.upGrade(person.grade);
        assertEquals(GradeEnum.GOLD, person.grade);

        person.grade = person.grade.downGrade(person.grade);
        assertEquals(GradeEnum.SILVER, person.grade);
        person.grade = person.grade.downGrade(person.grade);
        assertEquals(GradeEnum.BRONZE, person.grade);
    }

    @Test
    @DisplayName("Person Model With Parameter")
    void personModelWithParameterTest() {
        var personTwo = new Person("jiro", 20, GradeEnum.BRONZE);
        assertEquals("Mr.Jiro", personTwo.name);
        assertNotEquals("jiro", personTwo.name);
        assertNotEquals("Jiro", personTwo.name);
        assertEquals(20, personTwo.age);
        assertNotEquals(15, personTwo.age);
        assertEquals(GradeEnum.BRONZE, personTwo.grade);

        personTwo.name = "saburo";
        assertEquals("saburo", personTwo.name);
        assertNotEquals("jiro", personTwo.name);

        personTwo.age = 25;
        assertEquals(25, personTwo.age);
        assertNotEquals(20, personTwo.age);

        personTwo.grade = GradeEnum.SILVER;
        assertEquals(GradeEnum.SILVER, personTwo.grade);
        assertNotEquals(GradeEnum.BRONZE, personTwo.grade);

        personTwo.grade = GradeEnum.GOLD;
        assertEquals(GradeEnum.GOLD, personTwo.grade);
        assertNotEquals(GradeEnum.BRONZE, personTwo.grade);
        assertNotEquals(GradeEnum.SILVER, personTwo.grade);
    }

    @Test
    @DisplayName("Person Model Validate Under Fifteen")
    void personModelValidateUnderFifteenTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("taro", 14, GradeEnum.BRONZE));
        assertEquals("under 15", exception.getMessage());
    }

    @Test
    @DisplayName("Person Model Validate Name Min Length Over")
    void personModelValidateNameMinLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("壱", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }

    @Test
    @DisplayName("Person Model Validate Name Max Length Over")
    void personModelValidateNameMaxLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("1234567890123456", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }
}