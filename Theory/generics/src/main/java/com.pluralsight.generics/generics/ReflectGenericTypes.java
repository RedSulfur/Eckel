package com.pluralsight.generics.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class ReflectGenericTypes {

    public static class DemoArray extends ArrayList<String> {}

    public static void main(String[] args) {
        ParameterizedType type =
                (ParameterizedType) DemoArray.class.getGenericSuperclass();
        Type[] typeArguments = type.getActualTypeArguments();
        System.out.println(Arrays.toString(typeArguments));
    }
}
