package com.pluralsight.generics.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Injector {

    private Map<Class<?>, Object> objectGraph = new HashMap<>();

    public Injector with(Object value) {
        objectGraph.put(value.getClass(), value);
        return this;
    }

    public <T> T newInstance (Class<T> type) {
        return (T) objectGraph.computeIfAbsent(type, this::instantiate);
    }

    private Object instantiate(Class<?> type) {

        Constructor<?>[] constructors = type.getConstructors();

        if(constructors.length != 1) {
            throw new IllegalArgumentException(type + " should have only one constructor");
        }

        Constructor<?> constructor = constructors[0];

        Object[] args = Arrays.stream(constructor.getParameterTypes())
                .map(this::newInstance)
                .toArray();

        return constructObjectUsingConstructor(constructor, args);
    }

    private Object constructObjectUsingConstructor(Constructor constructor, Object... args) {
        Object constructedObject = null;
        try {
            constructedObject = constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return constructedObject;
    }
}
