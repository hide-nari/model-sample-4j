package com.hidenari;

interface AgeInterface {
    int INIT_AGE = 15;

    default void overFifteen(int age) {
        if (age < 15) {
            throw new IllegalArgumentException("under 15");
        }
    }
}
