package com.preparation.interfaces;

import java.util.Arrays;

/**
 * Created by sulfur on 05.04.16.
 */

class Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class UpCase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class LoCase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Split extends Processor {

    @Override
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

/*
Решение при котором поведение метода изменяется в зависимости от переданного
обьекта-аргумента, называется паттерн "Стратегия"
*/

//Метод содержит фиксированную часть алгоритма, а обьект стратегии - переменную

public class ClassProcessor {

    public static void process(Processor p, Object s) {
        System.out.println("Используется процессор " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "Gently my mind escapes to relxing mode of pleasure";

    public static void main(String[] args) {

        process(new UpCase(), s);
        process(new LoCase(), s);
        process(new Split(), s);
    }
}
