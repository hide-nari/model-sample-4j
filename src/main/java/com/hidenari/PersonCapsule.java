package com.hidenari;

public final class PersonCapsule implements NameCapsuleInterface, AgeCapsuleInterface {
    private String name;
    private int age;
    private GradeEnum grade;

    public PersonCapsule(String name, int age, GradeEnum grade) {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        this.grade = grade;
        validateNameLength(name);
        overFifteen(age);
    }

    public PersonCapsule() {
        this(NameCapsuleInterface.INIT_NAME,
                AgeCapsuleInterface.INIT_AGE,
                GradeEnum.BRONZE);
    }

    @Override
    @ValidateNameLength(min = 1, max = 16)
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

    public GradeEnum getGrade() {
        return grade;
    }

    public void setGrade(GradeEnum grade) {
        this.grade = grade;
    }
}
