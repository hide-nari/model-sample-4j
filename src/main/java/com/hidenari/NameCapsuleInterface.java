package com.hidenari;

import java.lang.reflect.Method;

sealed interface NameCapsuleInterface permits PersonCapsule {
    String INIT_NAME = "taro";

    String getName();

    void setName(String name);

    default void validateNameLengthCheck(String name) {
        try {
            Method nameSetMethod = PersonCapsule.class.getMethod("getName");
            ValidateNameLength param = nameSetMethod.getAnnotationsByType(ValidateNameLength.class)[0];
            if (name.length() <= param.min() || name.length() >= param.max()) {
                throw new IllegalArgumentException("name length is invalid");
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
