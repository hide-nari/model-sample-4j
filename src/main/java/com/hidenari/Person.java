package com.hidenari;

import com.hidenari.Enum.GradeEnum;

public final class Person implements NameInterface, AgeInterface {
    @ValidateNameLength(min = 1, max = 16)
    public String name;
    public int age;
    public GradeEnum grade;

    public Person(String name, int age, GradeEnum grade) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        this.grade = grade;
        validateNameLengthCheck(name);
        overFifteen(age);
    }

    public Person() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE, GradeEnum.BRONZE);
    }
}
