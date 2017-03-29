package com.pluralsight.generics.heterogeneus;

import java.math.BigDecimal;

public class FavouritesDemo {

    public static void main(String[] args) {

        Favourites f = new Favourites();
        f.putFavourite(Integer.class, 1);
        f.putFavourite(String.class, "One");
        f.putFavourite(BigDecimal.class, new BigDecimal(15.0));

        System.out.println(f.getFavourite(String.class));
    }
}
