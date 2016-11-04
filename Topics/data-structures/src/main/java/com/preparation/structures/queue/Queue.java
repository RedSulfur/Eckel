package com.preparation.structures.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int queueSize;

    public Queue() {
        first = null;
        last = null;
        queueSize = 0;
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return queueSize;
    }

    public Item peek() {
        if(first == null) throw new NoSuchElementException("Cannot peek if queue is empty");
        return first.item;
    }

    public void enqueue(Item item) {

        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        queueSize++;
    }

    public Item dequeue() {

        if(isEmpty()) throw new NoSuchElementException("Cannot dequeue if queue is empty");
        Item item = first.item;
        first = first.next;
        queueSize--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}