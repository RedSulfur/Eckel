package princeton.week3.merge_sort;

public class Merge {

    private Merge() {
    }

    public static void sort(Comparable[] values) {
        Comparable[] aux = new Comparable[values.length];
        sort(values, aux, 0, values.length - 1);
    }

    private static void sort(Comparable[] values, Comparable[] aux,
                             int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(values, aux, low, mid);
        sort(values, aux, mid + 1, high);
        merge(values, aux, low, mid, high);
    }

    private static void merge(Comparable[] values, Comparable[] aux,
                              int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = values[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) values[k] = aux[j++];
            else if (j > high) values[k] = aux[i++];
            else if (less(aux[j], aux[i])) values[k] = aux[j++];
            else values[k] = aux[i++];
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}
