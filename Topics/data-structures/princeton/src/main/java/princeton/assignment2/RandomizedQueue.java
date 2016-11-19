package princeton.assignment2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] array;
    private int queueSize;

    public RandomizedQueue() {
        array = (Item[]) new Object[1];
    }

    private RandomizedQueue(Item[] items, int queueSize) {
        this.array = (Item[]) new Object[queueSize];
        System.arraycopy(items, 0, array, 0, array.length); //queueSize?
        this.queueSize = queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public int size() {
        return queueSize;
    }

    public void enqueue(Item item) {
        if(item == null) throw new NullPointerException("You cannot add nul items in queue");
        if(queueSize == array.length) resize(2 * array.length);
        array[queueSize++] = item;
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < queueSize; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("You cannot dequeue from an empty queue");
        int index = StdRandom.uniform(0, queueSize);
        Item item = array[index];
        array[index] = array[--queueSize];
        array[queueSize] = null;
        if(queueSize > 0 && queueSize == array.length / 4) {
            resize(2 * array.length / 2);
        }
        return item;
    }

    public Item sample() {
        if(isEmpty()) throw new NoSuchElementException("You cannot dequeue from an empty queue");
        int index = StdRandom.uniform(0, queueSize);
        return array[index];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private RandomizedQueue<Item> randomizedQueue =
                new RandomizedQueue<>((Item[]) array, queueSize);

        @Override
        public boolean hasNext() {
            return randomizedQueue.size() != 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("You cannot dequeue from an empty queue");
            return randomizedQueue.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove method is not supported");
        }
    }
}
