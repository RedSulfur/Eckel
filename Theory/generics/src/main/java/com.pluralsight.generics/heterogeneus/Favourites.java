package com.pluralsight.generics.heterogeneus;

import java.util.HashMap;
import java.util.Map;

public class Favourites {

    private Map<Class<?>, Object> favourites = new HashMap<>();

    public <T> void putFavourite(Class<T> type, T instance) {
        if(instance == null) {
            throw new IllegalStateException("Instance is null");
        }
        favourites.put(type, type.cast(instance));
    }

    public <T> T getFavourite(Class<T> type) {
        return type.cast(favourites.get(type));
    }
}
