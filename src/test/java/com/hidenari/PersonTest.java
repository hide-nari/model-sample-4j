package com.hidenari;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Model Test")
class PersonTest {
    private final Person person = new Person();
    private final Person personWithParam = new Person("jiro", 20, GradeEnum.BRONZE);

    @Test
    @DisplayName("Person Model")
    void personModelTest() {
        assertEquals("Mr.Taro", person.name);
        assertNotEquals("taro", person.name);
        assertNotEquals("Taro", person.name);
        assertEquals(15, person.age);
        assertEquals(GradeEnum.BRONZE, person.grade);

        person.name = "jiro";
        assertEquals("jiro", person.name);
        assertNotEquals("taro", person.name);

        person.age = 20;
        assertEquals(20, person.age);
        assertNotEquals(15, person.age);

        person.grade = GradeEnum.SILVER;
        assertEquals(GradeEnum.SILVER, person.grade);
        assertNotEquals(GradeEnum.BRONZE, person.grade);

        person.grade = GradeEnum.GOLD;
        assertEquals(GradeEnum.GOLD, person.grade);
        assertNotEquals(GradeEnum.BRONZE, person.grade);
        assertNotEquals(GradeEnum.SILVER, person.grade);
    }

    @Test
    @DisplayName("Person Model Enum Function")
    void personModelEnumFunctionTest() {
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
        assertEquals("Mr.Jiro", personWithParam.name);
        assertNotEquals("jiro", personWithParam.name);
        assertNotEquals("Jiro", personWithParam.name);
        assertEquals(20, personWithParam.age);
        assertNotEquals(15, personWithParam.age);
        assertEquals(GradeEnum.BRONZE, personWithParam.grade);

        personWithParam.name = "saburo";
        assertEquals("saburo", personWithParam.name);
        assertNotEquals("jiro", personWithParam.name);

        personWithParam.age = 25;
        assertEquals(25, personWithParam.age);
        assertNotEquals(20, personWithParam.age);

        personWithParam.grade = GradeEnum.SILVER;
        assertEquals(GradeEnum.SILVER, personWithParam.grade);
        assertNotEquals(GradeEnum.BRONZE, personWithParam.grade);

        personWithParam.grade = GradeEnum.GOLD;
        assertEquals(GradeEnum.GOLD, personWithParam.grade);
        assertNotEquals(GradeEnum.BRONZE, personWithParam.grade);
        assertNotEquals(GradeEnum.SILVER, personWithParam.grade);
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