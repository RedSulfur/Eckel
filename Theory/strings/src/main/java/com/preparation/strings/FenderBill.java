package com.preparation.strings;


import java.util.Formatter;


public class FenderBill {
    private double total;
    Formatter f;

    public FenderBill(Formatter f) {
//        Весь вывод, производящийся по ссылке f направляется в поток System.out
        this.f = f;
    }

    public void printTitle() {
        f.format("%-21s %8s %-12s \n", "Article", "Quantity", "Price");
        f.format("%-21s %8s %-12s \n", "---------------------", "-------", "---------");
    }

    public void print(String name, int qty, double price) {
        /*
        Для обьектов String точность задает максимальное кол-во вводимых символов.
        Ширина - обьект Formatter гарантирует что выходное поле занимает не меньше указанного количества символов
        */
        f.format("%-21.19s %4d %12.2f \n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%21s %8s %-12s \n", "", "", "---------");
        f.format("%-21s %8s %-12.2f", "Total", "", total);
    }

//    public static final String fileOut = "/home/sulfur/IdeaProjects/Preparation/Theory/practice/src/main/java/com/preparation/practice/FenderBill.txt";

    public static void main(String[] args) {

//            File file = new File(fileOut);
            FenderBill fb = new FenderBill(new Formatter(System.out));
            fb.printTitle();
            fb.print("Fender Jazzmaster",2, 14999.99);
            fb.print("Fender Telecaster",1, 12999.99);
            fb.print("Fender Stratocaster Custom Shop",3, 15999.99);
            fb.printTotal();


    }
}
