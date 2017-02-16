package princeton.week3;

@SuppressWarnings("Duplicates")
public class MaxPQ<Key extends Comparable> {
    private Key[] pq;
    private int size;

    public MaxPQ(int size) {
        this.pq = (Key[]) new Object[size + 1];
    }

    public int size() {
        return size;
    }

    public void insert(Key v) {
        pq[++size] = v;
        swim(size);
    }

    private void swim(int k) {
        while (k/2 > 1 && less(k/2, k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    public Key delMax() {
        Key max = pq[1];
        swap(1, size--);
        pq[size + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if(j < size && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int k) {
        return pq[i].compareTo(pq[k]) < 0;
    }

    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
