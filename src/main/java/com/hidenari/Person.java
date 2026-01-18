package com.hidenari;

public class Person implements NameInterface, AgeInterface {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        if (age < 15) {
            throw new IllegalArgumentException("under 15");
        }
        this.age = age;
    }

    public Person() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE);
    }
}
