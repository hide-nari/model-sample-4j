package com.hidenari;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }

    Person() {
        this("taro", 15);
    }
}
