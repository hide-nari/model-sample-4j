package com.hidenari;

public class PersonCapsule {
    private String name;
    private int age;

    public PersonCapsule(String name, int age) {
        this.name = "Mr." + name;
        this.age = age;
    }

    public PersonCapsule() {
        this("taro", 15);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
