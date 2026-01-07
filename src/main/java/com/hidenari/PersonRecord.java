package com.hidenari;

public record PersonRecord(String name, int age) {
    public PersonRecord(String name, int age) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
    }
}

//public final class PersonRecord {
//    private final String name;
//    private final int age;
//
//    public PersonRecord(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String name() {
//        return name;
//    }
//
//    public int age() {
//        return age;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) return true;
//        if (obj == null || obj.getClass() != this.getClass()) return false;
//        var that = (PersonRecord) obj;
//        return Objects.equals(this.name, that.name) &&
//                this.age == that.age;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
//
//    @Override
//    public String toString() {
//        return "PersonRecord[" +
//                "name=" + name + ", " +
//                "age=" + age + ']';
//    }
//
//}

