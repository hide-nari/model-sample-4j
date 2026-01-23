package com.hidenari;

import com.hidenari.Enum.GradeEnum;
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
    public void personModelEnumFunctionTest() {
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
    public void personModelWithParameterTest() {
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
    public void personModelValidateUnderFifteenTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("taro", 14, GradeEnum.BRONZE));
        assertEquals("under 15", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMinLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("壱", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMaxLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("1234567890123456", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }
}