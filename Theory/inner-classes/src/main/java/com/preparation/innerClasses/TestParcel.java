package com.preparation.innerClasses;


class Parcel {

    private class PContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String whereTo;

        public PDestination(String whereTo) {
            this.whereTo = whereTo;
        }

        public String readLabel() {
            return whereTo;
        }
    }

    public PContents contents() {
        return new PContents();
    }

    public PDestination destination(String whereTo) {
        return new PDestination(whereTo);
    }
}

public class TestParcel {
    public static void main(String[] args) {

        Parcel p = new Parcel();
        Destination d = p.destination("Some location");
        Contents c = p.contents();

        /*
        Класс обьявлен как protected, следовательно доступ к нему имеют только
        внешний класс, классы одного пакета с ним, а также его наследники.
         */

        Parcel.PDestination pd = p.new PDestination("Some loc");


        /*
        Нельзя даже провести нисходящее преобразование к закрытому внутреннему
        классу (или к защищенному внутреннему классу, кроме как из его нас-
        ледника), так как у вас нет доступа к его имени.
        */

//        Parcel.PDestination upcast = new Parcel();
        
        /*
        Поскольку внутренний класс обьявлен как private, то к нему нигде
        нельзя получить доступ кроме как во внешнем классе.
        */

//        Parcel.PContents pc = p.new PContents();
    }
}
