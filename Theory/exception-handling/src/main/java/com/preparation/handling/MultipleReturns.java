package com.preparation.handling;

/**
 * Created by sulfur on 12.04.16.
 */
public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Инициализация требующая завершения");
        try {
        System.out.println("1 Точка");
        if(i == 1) return;
        System.out.println("2 Точка");
        if(i == 2) return;
        System.out.println("3 Точка");
        if(i == 3) return;
        System.out.println("Конец");
        return;
        } finally {
            System.out.println("Завершающие действия");
        }

    }

    public static void main(String[] args) {
        for(int i = 0; i < 4; i ++) {
            f(i);
        }
    }

}
