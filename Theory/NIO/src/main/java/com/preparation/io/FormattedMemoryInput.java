package com.preparation.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by sulfur on 04.04.16.
 */
public class FormattedMemoryInput {

    public static void main(String[] args) {
        try {
            /*
            Вля чтения форматированных данных применяется класс DataInputStream,
            ориентированный на ввод-вывод байтов(а не символов). Это вынуждает рабо-
            тать с классами иерархии InputStream, а не их аналогов на основе класса.

            */
            DataInputStream in = new DataInputStream(
            /*
            DataInputStream - позволяет выполнять чтение всех простых типов данных
            Java в двоичном формате
            */
                    new ByteArrayInputStream(BufferedInputFile

                            .read("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/FormattedMemoryInput.java").getBytes()));
            /*
            Поток ByteArrayInputStream должен получать массив байтов. Для его созда-
            ния в String имеется метод getBytes(). После этой операции в нас оказыва-
            ется необходимый поток InputStream, который можно передать DataInputStream


            in.available() - сообщает сколько еще осталось символов при чтении
            байтов из форматированного потока DataInputStream
            */
            while (in.available() != 0) {
                System.out.print((char)in.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
//            System.err.println("End of stream");
        }
    }
}
