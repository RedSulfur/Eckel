package com.preparation.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @see com.preparation.io.FileOutputShortcut
 *
 */

public class BufferedInputFile {

    public static String
    read(String filename) throws IOException {
        /*
        Ускорить процесс чтения позволяет буфферизация ввода, для чего
        полученная ссылка передается конструктору класса BufferedReader.
        Метод readLine() из класса BufferedReader возвращает ссылку null,
        если вы находитесь в конце файла
        */
        /*

        FileReader class inherits from the InputStreamReader class.
        FileReader is used for reading streams of characters.

        This class has several constructors to create required objects.
        */

        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");

        }
        /*
        По завершении чтения или записи данных в поток ввода-вывода следует
        закрыть его, вызвав метод close(). Такой вызов приведет к освобождению
        системных ресурсов. Закрытие потока вывода приводит к очистке исполь-
        зовавшегося буфера: все символы, которые временно размещались в этом
        буфере с целью из последующей доставки в виде более крупного пакета,
        рассылаются по местам своего назначения. Так, если не закрыть файл,
        последний пакет байтов может так никогда и не быть доставлен.
        */
        in.close();
    return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/BufferedInputFile.java"));
    }

}
