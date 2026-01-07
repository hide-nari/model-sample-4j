package com.hidenari;

class PersonCapsule {
    private String name;
    private int age;

    PersonCapsule(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }

    PersonCapsule() {
        this("taro", 15);
    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
}
