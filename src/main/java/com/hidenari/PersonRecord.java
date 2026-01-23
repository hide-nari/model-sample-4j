package com.hidenari;

public record PersonRecord(
        @ValidateNameLength(min = 1, max = 16)
        String name,
        int age,
        GradeEnum grade)
        implements NameInterface, AgeInterface {

    public PersonRecord(String name, int age, GradeEnum grade) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        this.grade = grade;
        validateNameLengthCheck(name);
        overFifteen(age);
    }

    public PersonRecord() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE, GradeEnum.BRONZE);
    }
}