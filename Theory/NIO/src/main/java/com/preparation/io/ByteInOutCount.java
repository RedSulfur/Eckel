package com.preparation.io;

import java.io.*;
import java.util.regex.Pattern;


public class ByteInOutCount {

    public static String text =
            "Gently my mind escapes into\n" +
            "relaxing mode of pleasure, \n" +
            "a pleasure that will take my mind";
    public static final String fileOut = "/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/ByteIO.txt";
    public static final String fileIn = "/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/ByteIO.txt";

    public static void main(String[] args) {

        // FileOutputStream - создает поток вывода и присоединяет его к конкретному файлу на диске
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            // DataOutputStream - позволяет выполнять запись простых типов данных в двоичном формате
            DataOutputStream out = new DataOutputStream(fileOutputStream);
            Pattern p = Pattern.compile("$",Pattern.MULTILINE);
            String[] strings = p.split(text);

            for (String s: strings) {
                // write string encoded as modified UTF-8
                out.writeUTF(s);
            }

            out.flush();

            FileInputStream fileInputStream = new FileInputStream(fileIn);
            // DataInputStream - позволяет производить чтение простых типо данных в двоичном формате
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(fileInputStream));

            // метод availible() проверяет кол-во байтов, доступных для чтения в данный момент
            int available = dataInputStream.available();

            byte[] data = new byte[available];

            dataInputStream.read(data);

            for (byte b : data) {
                System.out.print((char) b);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
