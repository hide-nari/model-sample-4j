package com.hidenari;

public record PersonRecord(
        @ValidateNameLength(min = 1, max = 16)
        String name,
        int age)
        implements NameInterface, AgeInterface {

    public PersonRecord(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        validateNameLength(name);
        overFifteen(age);
    }

    public PersonRecord() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE);
    }
}