package com.hidenari;

public record PersonRecord(String name, int age) implements NameInterface, AgeInterface {
    public PersonRecord(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }

    public PersonRecord() {
        this(NameInterface.INIT_NAME, AgeInterface.INIT_AGE);
    }
}