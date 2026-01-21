package com.hidenari;

import java.lang.reflect.Field;

sealed interface NameCapsuleInterface permits PersonCapsule {
    String INIT_NAME = "taro";

    String getName();

    void setName(String name);

    default void validateNameLength(String name) throws NoSuchFieldException {
        Field nameField = Person.class.getField("name");
        ValidateNameLength param = nameField.getAnnotationsByType(ValidateNameLength.class)[0];
        if (name.length() <= param.min() || name.length() >= param.max()) {
            throw new IllegalArgumentException("name length is invalid");
        }
    }
}
