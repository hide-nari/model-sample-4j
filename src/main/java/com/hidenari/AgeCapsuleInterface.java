package com.hidenari;

sealed interface AgeCapsuleInterface permits PersonCapsule {
    int INIT_AGE = 15;

    int getAge();

    void setAge(int age);

    default void overFifteen(int age) {
        if (age < 15) {
            throw new IllegalArgumentException("under 15");
        }
    }
}
