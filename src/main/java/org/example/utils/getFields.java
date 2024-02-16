package org.example.utils;

import java.lang.reflect.Field;
import java.util.List;

public class getFields {
    public static List<Field> getFields(Class<?> clazz) {
        return List.of(clazz.getDeclaredFields());
    }
}
