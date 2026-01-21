package com.hidenari;

public final class Person implements NameInterface, AgeInterface {
    @ValidateNameLength(min = 1, max = 16)
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        validateNameLength(name);
        overFifteen(age);
    }

    public Person() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE);
    }
}
