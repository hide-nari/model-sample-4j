package com.hidenari;

public class Person implements NameInterface {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }

    public Person() {
        this(NameInterface.INIT_NAME, 15);
    }
}
