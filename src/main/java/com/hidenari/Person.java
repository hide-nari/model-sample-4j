package com.hidenari;

public class Person implements NameInterface, AgeInterface {

    @ValidateName(minLength = 5,maxLength = 10)
    public String name;
    public int age;

    public Person(String name, int age) throws NoSuchFieldException {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        validateNameLength(this.name);
        overFifteen(age);
    }

    public Person() throws NoSuchFieldException {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE);
    }
}
