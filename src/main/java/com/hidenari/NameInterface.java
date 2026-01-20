package com.hidenari;

import java.lang.reflect.Field;

interface NameInterface {
    String INIT_NAME = "taro";

    default void validateNameLength(String name) throws NoSuchFieldException {
        Field nameField = Person.class.getField("name");
        ValidateName param = nameField.getAnnotationsByType(ValidateName.class)[0];
        if (name.length() <= param.minLength() || name.length() >= param.maxLength()) {
            throw new IllegalArgumentException("name length is invalid");
        }
    }
}
