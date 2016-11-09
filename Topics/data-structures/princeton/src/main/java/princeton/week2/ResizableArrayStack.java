package princeton.week2;

import java.util.Iterator;

public class ResizableArrayStack<Item> implements Iterable<Item> {

    private Item[] array = (Item[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void push(Item item) {
        if(size == array.length) resize(2 * array.length);
        array[size++] = item;
    }

    public Item pop() {
        Item item = array[--size];
        array[size] = null;
        if(size > 0 && size == array.length / 4) resize(array.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        // iterator methods should not have an impact on
        // the object of the class it iterates
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return array[--i];
        }
    }
}
