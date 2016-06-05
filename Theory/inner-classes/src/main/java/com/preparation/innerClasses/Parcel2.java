package com.preparation.innerClasses;

/**
 * Created by sulfur on 07.04.16.
 */
public class Parcel2 {

    /*
    Если значение передается базовому конструктору анонимного класса и
    используется напрямую в анонимном классе, то компилятор требует,
    чтобы ссылка на аргумент была обьявлена как final
     */

    public Destination destination(final String dest, final float price) {

        /*
        Анонимный внутренний класс не может иметь конструкторов, поскольку
        имя конструктора должно совпадать с именем класса, а у анонимного
        класса отсутствует имя.


        Внешние фигурные скобки образуют анонимный подкласс Destination,
        а внутренние - блок конструирования обьектов.
         */

        return new Destination() {
            int cost;
            {
                cost = Math.round(price);
                if(cost > 100) System.out.println("Превышение бюджета!");
            }
            String label = dest;
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel2 p2 = new Parcel2();
        Destination d = p2.destination("Some desired loc", 666f);
    }
}
