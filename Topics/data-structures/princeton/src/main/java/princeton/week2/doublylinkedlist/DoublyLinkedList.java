package princeton.week2.doublylinkedlist;

import java.util.ListIterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = new Node<>();
        this.tail = new Node<>();
        head.previous = tail;
        tail.next = head;
    }

    private static class Node<Item> {
        private Node<Item> next;
        private Node<Item> previous;
        private Item item;
    }

    public void add(Item item) {
        Node<Item> oldHead = head.previous;
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        oldHead.next = newNode;
        newNode.previous = oldHead;
        newNode.next = head;
        head.previous = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Item item : this) {
            sb.append(item + " ");
        }
        return sb.toString();
    }

    @Override
    public ListIterator<Item> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements ListIterator<Item> {

        private Node<Item> lastAccessed;
        private Node<Item> current = tail.next;
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            lastAccessed = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        @Override
        public Item previous() {
            if (!hasPrevious()) {
                throw new IllegalStateException();
            }
            current = current.previous;
            lastAccessed = current;
            index--;
            return current.item;
        }

        @Override
        public void add(Item item) {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            Node<Item> prevNode = current.previous;
            Node<Item> newNode = new Node<>();
            Node<Item> nextNode = current;
            newNode.item = item;
            prevNode.next = newNode;
            newNode.previous = prevNode;
            newNode.next = nextNode;
            nextNode.previous = newNode;
            size++;
            index++;
            lastAccessed = null;
        }

        @Override
        public void remove() {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            Node<Item> nextNode = lastAccessed.next;
            Node<Item> prevNode = lastAccessed.previous;

            prevNode.next = nextNode;
            nextNode.previous = prevNode;

            if(lastAccessed == current) {
                current = nextNode;
            } else {
                index--;
            }
            size--;
            lastAccessed = null;
        }

        @Override
        public void set(Item item) {
            if (lastAccessed == null) {
                throw new IllegalStateException();
            }
            current.item = item;
        }
    }
}
