package com.hidenari;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Person model root")
class PersonTest {
    private Person person;

    @Nested
    @DisplayName("Person model group")
    class PersonModelTest {
        @BeforeEach
        void setUp() {
            person = new Person();
        }

        @Test
        @DisplayName("Person model name")
        void personModelNameTest() {
            assertEquals("Mr.Taro", person.name);
            assertNotEquals("taro", person.name);
            assertNotEquals("Taro", person.name);

            person.name = "jiro";
            assertEquals("jiro", person.name);
            assertNotEquals("taro", person.name);
        }

        @Test
        @DisplayName("Person model age")
        void personModelAgeTest() {
            assertEquals(15, person.age);

            person.age = 20;
            assertEquals(20, person.age);
            assertNotEquals(15, person.age);
        }

        @Test
        @DisplayName("Person model grade")
        void personModelGradeTest() {
            assertEquals(GradeEnum.BRONZE, person.grade);

            person.grade = GradeEnum.SILVER;
            assertEquals(GradeEnum.SILVER, person.grade);
            assertNotEquals(GradeEnum.BRONZE, person.grade);

            person.grade = GradeEnum.GOLD;
            assertEquals(GradeEnum.GOLD, person.grade);
            assertNotEquals(GradeEnum.BRONZE, person.grade);
            assertNotEquals(GradeEnum.SILVER, person.grade);
        }

        @Test
        @DisplayName("Person model grade function")
        void personModelUpGradeFunctionTest() {
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
    @DisplayName("Person model with parameter group")
    class PersonModelWithParamTest {

        @BeforeEach
        void setUp() {
            person = new Person("jiro", 20, GradeEnum.BRONZE);
        }

        @Test
        @DisplayName("Person model with parameter name")
        void personModelWithParameterNameTest() {
            assertEquals("Mr.Jiro", person.name);
            assertNotEquals("jiro", person.name);
            assertNotEquals("Jiro", person.name);

            person.name = "saburo";
            assertEquals("saburo", person.name);
            assertNotEquals("jiro", person.name);
        }

        @Test
        @DisplayName("Person model with parameter age")
        void personModelWithParameterAgeTest() {
            assertEquals(20, person.age);
            assertNotEquals(15, person.age);

            person.age = 25;
            assertEquals(25, person.age);
            assertNotEquals(20, person.age);
        }

        @Test
        @DisplayName("Person model with parameter grade")
        void personModelWithParameterGradeTest() {
            assertEquals(GradeEnum.BRONZE, person.grade);

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
    @DisplayName("Person model error group")
    class PersonModelErrorTest {
        @Test
        @DisplayName("Person model validate under fifteen")
        void personModelValidateUnderFifteenTest() {
            var exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Person("taro", 14, GradeEnum.BRONZE));
            assertEquals("under 15", exception.getMessage());
        }

        @Test
        @DisplayName("Person model validate name min length")
        void personModelValidateNameMinLengthTest() {
            var exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Person("壱", 15, GradeEnum.BRONZE));
            assertEquals("name length is invalid", exception.getMessage());
        }

        @Test
        @DisplayName("Person model validate name max length")
        void personModelValidateNameMaxLengthTest() {
            var exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> new Person("1234567890123456", 15, GradeEnum.BRONZE));
            assertEquals("name length is invalid", exception.getMessage());
        }
    }
}