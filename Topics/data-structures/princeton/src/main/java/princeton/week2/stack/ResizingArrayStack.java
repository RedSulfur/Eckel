package princeton.week2.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] stackArray;
    private int size;

    public ResizingArrayStack() {
        stackArray = (Item[]) new Object[2];
        size = 0;
    }

    public void push(Item item) {
        if (size == stackArray.length) {
            resize(2 * stackArray.length);
        }
        stackArray[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        if (size > 0 && size == stackArray.length / 4) {
            resize(stackArray.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(stackArray, 0, temp, 0, size);
        stackArray = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayStackIterator();
    }

    private class ResizingArrayStackIterator implements Iterator<Item> {

        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = stackArray[index];
            index--;
            return item;
        }
    }
}
