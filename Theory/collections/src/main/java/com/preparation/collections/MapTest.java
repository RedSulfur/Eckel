package com.preparation.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sulfur on 10.04.16.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String,Item> itemMap = new HashMap<>();
        itemMap.put("1111",new Item("Death",13));
        itemMap.put("2222",new Item("Martyr",555));
        itemMap.put("3333",new Item("Suffering",666));
        itemMap.put("4444",new Item("Shadow of the soul",666));

        System.out.println(itemMap);

        itemMap.remove("4444");

        itemMap.put("1111", new Item("Rotting soul",21));

        System.out.println(itemMap.get("1111"));

        /*
        В архитектуре коллекций само отображение не рассматривается в качестве коллекции.
        Тем не менее можно получить представление отдельного отображения. (Обьекты, реализующие
        интерфейс Collection или один из его подчиненных интерфейсов).

        Имеются 3 таких представления: множество ключей, коллекция(не множество) значений и множество
        пар ключ-значение. Ключи и пары ключ-значения образуют множество так как в отображении
        может присутствовать только по одной копии обьекта ключа.
         */
        for(Map.Entry<String,Item> item : itemMap.entrySet()) {
            String key = item.getKey();
            Item temp = item.getValue();
            System.out.println("We have a key: " + key + " associated with the value: " + temp);
        }

        /*Set<String> redeemPain = new HashSet<>();

        redeemPain.add("1111");
        redeemPain.add("3333");

        itemMap.keySet().removeAll(redeemPain);

        System.out.println("\n\n");

        for(Map.Entry<String,Item> item : itemMap.entrySet()) {
            String key = item.getKey();
            Item temp = item.getValue();
            System.out.println("We have a key: " + key + " associated with the value: " + temp);
        }*/

    }
}
