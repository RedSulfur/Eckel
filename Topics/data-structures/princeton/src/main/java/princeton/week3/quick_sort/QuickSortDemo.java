package princeton.week3.quick_sort;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] ints = new int[]{7, 4, 8, 3, 2, 9, 5, 3};
        System.out.println("Unsorted: " + Arrays.toString(ints));
        QuickSort.sort(ints);
        System.out.println("Sorted: " + Arrays.toString(ints));
    }
}
