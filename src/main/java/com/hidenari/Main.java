package com.hidenari;

public class Main {
    static void main() throws NoSuchFieldException {
        var person = new Person("taro", 15, GradeEnum.BRONZE);
        person.grade = person.grade.upGrade(person.grade);
        System.out.println(person.grade.toString());
        person.grade = person.grade.upGrade(person.grade);
        System.out.println(person.grade.toString());
        person.grade = person.grade.downGrade(person.grade);
        System.out.println(person.grade.toString());
        person.grade = person.grade.downGrade(person.grade);
        System.out.println(person.grade.toString());
    }
}
