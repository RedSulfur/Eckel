package com.pluralsight.generics;

public class QueueDemo {

    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue<>(10);

        queue.offer("a");
        queue.offer("bc");
        queue.offer("d");

        String concatenatedElements = concatenate(queue);
        System.out.println(concatenatedElements);
    }

    private static String concatenate(GenericQueue<String> queue) {

        StringBuffer sb = new StringBuffer();
        String value;
        while ((value = (String) queue.poll()) != null) {
            sb.append(value);
        }

        return sb.toString();
    }
}
