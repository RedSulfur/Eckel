package com.preparation.algorithms;

import com.preparation.algorithms.interfaces.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueBehaviour {

private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {

        for (int i = 0; i < count; i++) {
            queue.offer(gen.next());
        }
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();

    }


    static class Gen implements Generator<String> {

        String[] parts = ("one two three four five" +
                " six seven eight nine ten").split(" ");
        int i;

        public String next() {
            return parts[i++];
        }
    }

    public static void main(String[] args) {

        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue<String>(), new Gen());



    }

}