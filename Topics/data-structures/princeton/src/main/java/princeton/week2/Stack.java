package princeton.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int size;

    public Stack(int size) {
        this.first = null;
        this.size = size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node<Item> oldFirst = first;
        Node<Item> first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Cannot get element from an empty stack");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item peek() {
        if(isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        return item;
    }

    private static class Node<Item> {
        Node<Item> next;
        Item item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
