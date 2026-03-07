package com.hidenari;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person Model Root")
class PersonTest {
    private Person person;

    @Nested
    @DisplayName("Person Model Group")
    class PersonModelTest {
        @BeforeEach
        void setUp() {
            person = new Person();
        }

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
    }

    @Nested
    @DisplayName("Person Model With Parameter Group")
    class PersonModelWithParamTest {

        @BeforeEach
        void setUp() {
            person = new Person("jiro", 20, GradeEnum.BRONZE);
        }

        @Test
        @DisplayName("Person Model With Parameter")
        void personModelWithParameterTest() {
            assertEquals("Mr.Jiro", person.name);
            assertNotEquals("jiro", person.name);
            assertNotEquals("Jiro", person.name);
            assertEquals(20, person.age);
            assertNotEquals(15, person.age);
            assertEquals(GradeEnum.BRONZE, person.grade);

            person.name = "saburo";
            assertEquals("saburo", person.name);
            assertNotEquals("jiro", person.name);

            person.age = 25;
            assertEquals(25, person.age);
            assertNotEquals(20, person.age);

            person.grade = GradeEnum.SILVER;
            assertEquals(GradeEnum.SILVER, person.grade);
            assertNotEquals(GradeEnum.BRONZE, person.grade);

            person.grade = GradeEnum.GOLD;
            assertEquals(GradeEnum.GOLD, person.grade);
            assertNotEquals(GradeEnum.BRONZE, person.grade);
            assertNotEquals(GradeEnum.SILVER, person.grade);
        }
    }

    @Nested
    @DisplayName("Person Model Error Group")
    class PersonModelErrorTest {
        @Test
        @DisplayName("Person Model Validate Under Fifteen")
        void personModelValidateUnderFifteenTest() {
            var exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Person("taro", 14, GradeEnum.BRONZE));
            assertEquals("under 15", exception.getMessage());
        }

        @Test
        @DisplayName("Person Model Validate Name Min Length Less")
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
}