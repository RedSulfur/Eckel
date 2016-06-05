package com.preparation.strings;


import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class BetterRead {

    public static void main(String[] args) {

        // Обьект StringReader преобразует String в поток, доступный для чтения
        // Readable - интерфейс для создания обьекта, содержащего метод read()
        BufferedReader br = new BufferedReader(new StringReader("Mr. Jekyll \n 22 2.71"));
        Scanner sc = new Scanner(br);


        System.out.println("What  is your name");
        String name =  sc.nextLine();
        System.out.println(name);

        System.out.println("How old are you? What is your favourite decimal?");
        System.out.println("(input: <age> <double>)");
        int age = sc.nextInt();
        double var = sc.nextDouble();
        System.out.println(age);
        System.out.println(var);
        System.out.format("Hi %s. \n", name);
        System.out.format("In 5 years you will be %d \n", (age + 5));
        System.out.format("My favourite double is %.3f \n", (var/2));



    }

}
