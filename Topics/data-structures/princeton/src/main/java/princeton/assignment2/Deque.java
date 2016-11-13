package princeton.assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int dequeSize;

    public Deque() {
        first = null;
        last = null;
    }

    private class Node<Item> {
        Node<Item> previous;
        Node<Item> next;
        Item item;

        @Override
        public String toString() {
            return "Node{" +
                    "previous=" + previous +
                    ", item=" + item +
                    '}';
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return dequeSize;
    }

    public Item removeLast() {
        Node<Item> oldLast = last;
        if(last == null) throw new NoSuchElementException("You cannot remove items from empty deque");
        last.next = null;
        last = last.previous;
        dequeSize--;
        return oldLast.item;
    }

    public void addLast(Item item) {
        if(item == null) throw new NullPointerException("You cannot add null items");
        Node<Item> oldLast = last;
        last = new Node<>();
        last.next = null;
        last.item = item;
        if(isEmpty()) {
            last.previous = null;
            first = last;
        } else {
            last.previous = oldLast;
            oldLast.next = last;
        }
        dequeSize++;
    }

    public void addFirst(Item item) {
        if(item == null) throw new NullPointerException("You cannot add null items");
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        if(oldFirst == null) {
            last = first;
            first.next = null;
            first.previous = null;
        } else {
            first.next = oldFirst;
            oldFirst.previous = first;
        }
        dequeSize++;
    }

    public Item removeFirst() {
        Node<Item> oldFirst = first;
        if(oldFirst == null) throw new NoSuchElementException("You cannot remove items from empty deque");

        first = first.next;
        if(first != null) first.previous = null;

        dequeSize--;

        return oldFirst.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(current == null) throw new NoSuchElementException("There are no more elements in the deque");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This method is not supported");
        }
    }
}
