package com.preparation.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sulfur on 21.04.16.
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        /*
        Компилятор пытается преобразовать this в String, для этого он вызывает метод
        toString, порождая рекурсивый вызов.
        */

        /*
        Если действительно необходимо получить адрес обьекта, задача решается
        вызовом метода toString() класса Object
        */
        return "Infinite recursion" + super.toString() + "\n";
//        return "Infinite recursion" + this;
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list = new ArrayList<InfiniteRecursion>();
        for(int i = 0; i < 10; i ++) {
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
