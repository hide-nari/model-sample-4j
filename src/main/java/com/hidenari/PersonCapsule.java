package com.hidenari;

public class PersonCapsule implements NameCapsuleInterface, AgeCapsuleInterface {
    private String name;
    private int age;

    public PersonCapsule(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }

    public PersonCapsule() {
        this(NameCapsuleInterface.INIT_NAME, AgeCapsuleInterface.INIT_AGE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
