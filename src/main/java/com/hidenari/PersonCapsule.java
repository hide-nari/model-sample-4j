package com.hidenari;

public final class PersonCapsule implements NameCapsuleInterface, AgeCapsuleInterface {
    @ValidateNameLength(min = 1, max = 16)
    private String name;
    private int age;

    public PersonCapsule(String name, int age) throws NoSuchFieldException {
        this.name = "Mr."
                + name.substring(0, 1).toUpperCase()
                + name.substring(1).toLowerCase();
        this.age = age;
        validateNameLength(name);
        overFifteen(age);
    }

    public PersonCapsule() throws NoSuchFieldException {
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
