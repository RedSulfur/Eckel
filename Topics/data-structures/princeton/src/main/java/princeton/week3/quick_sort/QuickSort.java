package princeton.week3.quick_sort;

@SuppressWarnings("Duplicates")
public class QuickSort {

    public static void sort(int[] values) {
        sort(values, 0, values.length - 1);
    }

    private static void sort(int[] values, int left, int right) {
        int index = partition(values, left, right);

        if (left < index - 1) {
            sort(values, left, index - 1);
        }
        if (index < right) {
            sort(values, index, right);
        }
    }

    private static int partition(int[] values, int left, int right) {

        int temp;
        int i = left, j = right;
        int pivot = values[(right + left) / 2];

        while (i <= j) {

            while (values[i] < pivot) {
                i++;
            }
            while (values[j] > pivot) {
                j--;
            }

            if (i <= j) {
                temp = values[i];
                values[i] = values[j];
                values[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
}
