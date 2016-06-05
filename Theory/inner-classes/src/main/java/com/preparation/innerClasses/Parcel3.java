package com.preparation.innerClasses;


public class Parcel3 {

    /*
    Если связь между обьектом внутреннего класса и обьектом внешнего класса вам не нужна,
    внутренний класс можно обьявить статическим. Такой класс называют вложенным.
    При этом обьект внутреннего класса уже не будет хранить ссылку на обьект
    создавшего его обрамляющего класса.

    Вложенный класс обладает следующими характеристиками:
    1. Для его создания не понадобится обьект внешнего класса
    2. Вы не можете обращаться к членам не-статического обьекта внешнего класса
    из обьекта вложенного класса
     */

    private static class ParcelContents
            implements Contents {

        private int i = 11;
        public int value() {
            return i;
        }
    }
    protected static class ParcelDestination
            implements Destination {

        private String label;

        public ParcelDestination(String label) {
            this.label = label;
        }

        public String readLabel() {
            return label;
        }
    }

    public static void f() {};
    static int x = 10;
    static class AnotherLevel {
        public static void f() {};
        static int x = 10;
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("Some loc");
    }

}
