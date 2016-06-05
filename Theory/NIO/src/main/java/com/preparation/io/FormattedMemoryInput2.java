package com.preparation.io;

import java.io.*;

/**
 * Created by sulfur on 04.04.16.
 */
public class FormattedMemoryInput2 {

    public static void main(String[] args) {
        try {
    /*
    В классе DataInputStream отсутствуют методы для извлечения данных
    из файла
    */
            DataInputStream in = new DataInputStream(

    /*
    Изначально потоки не буферизуются. Это означает, что каждый вызов метода read()
    приводит к запрашиванию у операционной системы выдачи очередного байта.
    Но намного эффективнее запрашивать сразу целые блоки данных и размещать их
    в буфере.
    */
                    new BufferedInputStream(
    /*
    В классах FileInput/OutputStream поддреживается чтение и запись только на
    уровне байтов.
    */
                            new FileInputStream("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/FormattedMemoryInput.java")));

            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
//            System.err.println("End of stream");
        }
    }
}
