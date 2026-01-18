package com.hidenari;

import com.sun.nio.sctp.IllegalUnbindException;

public class Main {
    static void main() {
        System.out.println(123);
        int age = 14;
        if(age < 15){
            throw new IllegalArgumentException("under 15");
        }
    }
}
