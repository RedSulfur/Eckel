package com.preparation.collections;


import java.util.LinkedList;

public class DequeTest {


    public static class Deque<T> {

        LinkedList<T> deque = new LinkedList<T>();
        public void addLast(T e) {deque.addLast(e);}
        public void addFirst(T e) {deque.addFirst(e);}
        public T getFirst() {return deque.getFirst();}
        public T getLast() {return deque.getLast();}
        public T removeLast() {return deque.removeLast();}
        public T removeFirst() {return deque.removeFirst();}
        public int size() {return deque.size();}

        @Override
        public String toString() {
            return deque.toString();
        }
    }

    public static void fillDeque(Deque<Integer> deque) {

        for (int i = 20; i < 26; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 56; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {

        Deque<Integer> integerDeque = new Deque<Integer>();
        fillDeque(integerDeque);
        System.out.println(integerDeque);

        while (integerDeque.size() != 0) {
            System.out.print(integerDeque.removeFirst() + " ");
        }

        fillDeque(integerDeque);
        System.out.println();

        while (integerDeque.size() != 0) {
            System.out.print(integerDeque.removeLast() + " ");
        }
    }
}
