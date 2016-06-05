package com.preparation.strings;

import java.io.*;

import static java.lang.String.format;

/**
 * Created by sulfur on 22.04.16.
 */
public class FormatInFile {

    private double total;
    private StringBuilder sb = new StringBuilder();

    public void printTitle() {
        sb.append(format("%-21s %8s %-12s \n", "Article", "Quantity", "Price"));
        sb.append(format("%-21s %8s %-12s \n", "---------------------", "--------", "---------"));
    }

    public void print(String name, int qty, double price) {
        /*
        Для обьектов String точность задает максимальное кол-во вводимых символов.
        Ширина - обьект Formatter гарантирует что выходное поле занимает не меньше указанного количества символов
        */
        sb.append(format("%-21.19s %4d %12.2f \n", name, qty, price));
        total += price;
    }

    public void printTotal() {
        sb.append(format("%21s %8s %-12s \n", "", "", "---------"));
        sb.append(format("%-21s %8s %-12.2f", "Total", "", total));
    }

    public String result() {
        return sb.toString();
    }

    public static final String fileOut = "/home/sulfur/IdeaProjects/Preparation/Theory/strings/src/main/java/com/preparation/strings/FenderBill.txt";

    public static void main(String[] args) {

        try {
            PrintStream out = new PrintStream(new FileOutputStream(fileOut));
            FormatInFile fb = new FormatInFile();
            fb.printTitle();
            fb.print("Fender Jazzmaster",2, 14999.99);
            fb.print("Fender Telecaster",1, 12999.99);
            fb.print("Fender Stratocaster Custom Shop",3, 15999.99);
            fb.printTotal();
            out.print(fb.result());
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
