package com.hidenari;

import java.lang.reflect.Field;

sealed interface NameInterface permits Person, PersonRecord {
    String INIT_NAME = "taro";

    default void validateNameLength(String name) {
        Field nameField = null;
        try {
            nameField = Person.class.getField("name");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e.getMessage());
        }
        ValidateNameLength param = nameField.getAnnotationsByType(ValidateNameLength.class)[0];
        if (name.length() <= param.min() || name.length() >= param.max()) {
            throw new IllegalArgumentException("name length is invalid");
        }
    }
}
