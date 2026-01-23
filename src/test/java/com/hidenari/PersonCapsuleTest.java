package com.hidenari;

import com.hidenari.Enum.GradeEnum;
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
        assertEquals(GradeEnum.BRONZE, person.getGrade());

        person.setName("jiro");
        assertEquals("Mr.Jiro", person.getName());
        assertNotEquals("jiro", person.getName());

        person.setAge(20);
        assertEquals(20, person.getAge());
        assertNotEquals(15, person.getAge());

        person.setGrade(GradeEnum.SILVER);
        assertEquals(GradeEnum.SILVER, person.getGrade());
        assertNotEquals(GradeEnum.BRONZE, person.getGrade());

        person.setGrade(GradeEnum.GOLD);
        assertEquals(GradeEnum.GOLD, person.getGrade());
        assertNotEquals(GradeEnum.SILVER, person.getGrade());
    }

    @Test
    public void personCapsuleModelEnumFunctionTest() {
        var person = new PersonCapsule();
        person.setGrade(person.getGrade().upGrade(person.getGrade()));
        assertEquals(GradeEnum.SILVER, person.getGrade());
        person.setGrade(person.getGrade().upGrade(person.getGrade()));
        assertEquals(GradeEnum.GOLD, person.getGrade());

        person.setGrade(person.getGrade().downGrade(person.getGrade()));
        assertEquals(GradeEnum.SILVER, person.getGrade());
        person.setGrade(person.getGrade().downGrade(person.getGrade()));
        assertEquals(GradeEnum.BRONZE, person.getGrade());
    }

    @Test
    public void personCapsuleModelWithParameterTest() {
        var personTwo = new PersonCapsule("jiro", 20, GradeEnum.BRONZE);
        assertEquals("Mr.Jiro", personTwo.getName());
        assertNotEquals("jiro", personTwo.getName());
        assertNotEquals("Jiro", personTwo.getName());
        assertEquals(20, personTwo.getAge());
        assertNotEquals(15, personTwo.getAge());
        assertEquals(GradeEnum.BRONZE, personTwo.getGrade());

        personTwo.setName("saburo");
        assertEquals("Mr.Saburo", personTwo.getName());
        assertNotEquals("jiro", personTwo.getName());

        personTwo.setAge(25);
        assertEquals(25, personTwo.getAge());
        assertNotEquals(20, personTwo.getAge());

        personTwo.setGrade(GradeEnum.SILVER);
        assertEquals(GradeEnum.SILVER, personTwo.getGrade());
        assertNotEquals(GradeEnum.BRONZE, personTwo.getGrade());

        personTwo.setGrade(GradeEnum.GOLD);
        assertEquals(GradeEnum.GOLD, personTwo.getGrade());
        assertNotEquals(GradeEnum.BRONZE, personTwo.getGrade());
        assertNotEquals(GradeEnum.SILVER, personTwo.getGrade());
    }

    @Test
    public void personModelValidateUnderFifteenTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonCapsule("taro", 14, GradeEnum.BRONZE));
        assertEquals("under 15", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMinLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonCapsule("壱", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }

    @Test
    public void personModelValidateNameMaxLengthOverTest() {
        var exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PersonCapsule("1234567890123456", 15, GradeEnum.BRONZE));
        assertEquals("name length is invalid", exception.getMessage());
    }
}