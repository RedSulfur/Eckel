package princeton.week3;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Heapsort<Key extends Comparable> {

    public static void main(String[] args) {
        Heapsort<String> heapsort = new Heapsort<>();
        String[] strings = "sortexample".split("");

        heapsort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    private void sort(Key[] input) {
        int size = input.length;
        for(int k = size/2; k >= 1; k--) {
            sink(input, k - 1, size);
        }
    }

    private void sink(Key[] input, int k, int size) {
        System.out.println(Arrays.toString(input));
        while (2*k <= size) {
            int j = 2*k + 1;
            if(j < size - 1 && less(input, j, j + 1)) j++;
            System.out.println("k: " + k + ", j:" + j);
            System.out.println("Comparing input[k]: " + input[k]
                    + " and input[j]: " + input[j]);
            if(!less(input, k, j)) break;
            System.out.println("Swapping input[k]: " + input[k]
                    + " and input[j]: " + input[j]);
            swap(input, k, j);
            k = j;
        }
    }

    private boolean less(Key[] input, int i, int j) {
        return input[i].compareTo(input[j]) < 0;
    }


    private void swap(Key[] input, int i, int j) {
        Key value = input[i];
        input[i] = input[j];
        input[j] = value;
    }
}
