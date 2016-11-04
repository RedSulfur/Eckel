package princeton.percolation;

public class Percolation {

    private static final int BLOCKED_SITE = -1;
    private static final int OPEN_SITE = 1;

    private int virtualTop;
    private int virtualBottom;
    private int[] array;
    private int[] weight;
    private int size;

    public Percolation(int n) {

        size = n;
        array = new int[size * size];
        weight = new int[size * size];

        for (int i = 0; i < size * size; i++) {
            array[i] = BLOCKED_SITE;
            weight[i] = 1;
        }
    }

    public void open(int row, int col) {

        int index = calculateIndex(row, col);
        System.out.println("Index = " + index);
        array[index] = index;

        if(array[index - size] != BLOCKED_SITE) {
            System.out.println("[index - size]");
            union(index, index - size);
        }
        if(array[index - 1] != BLOCKED_SITE) {
            System.out.println("[index - 1]");
            union(index, index - 1);
        }
        if(array[index + 1] != BLOCKED_SITE) {
            System.out.println("[index + 1]");
            union(index, index + 1);
        }
        if(array[index + size] != BLOCKED_SITE) {
            System.out.println("[index + size]");
            union(index, index + size);
        }
    }

    private int find(int p) {
        while(p != array[p]) {
            p = array[p];
        }
        return p;
    }

    //for testing purposes
    public int find(int row, int col) {
        int p = calculateIndex(row, col);
        System.out.println("p in find: " + p);
        if(array[p] == BLOCKED_SITE) return -1;
        while(p != array[p]) {
            System.out.println("array[p] in find#while: " + array[p]);
            p = array[p];
        }
        System.out.println("Have found p: " + p);
        return p;
    }

    @SuppressWarnings("Duplicates")
    private void union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);

        if(iRoot == jRoot) return;

        if(weight[iRoot] < weight[jRoot]) {
            System.out.println("In if:");
            array[iRoot] = jRoot;
            System.out.println("weight[jRoot] = " + weight[jRoot]);
            weight[jRoot] += weight[iRoot];
            System.out.println("After gaining: weight[jRoot] = " + weight[jRoot]);
        } else {
            System.out.println("In else:");
            array[jRoot] = iRoot;
            System.out.println("weight[iRoot] = " + weight[iRoot]);
            weight[iRoot] += weight[jRoot];
            System.out.println("After gaining: weight[iRoot] = " + weight[iRoot]);
        }
        System.out.println("United: array[iRoot] = " + array[iRoot] + ", array[jRoot] = " + array[jRoot]);
        System.out.println("array[]");
    }

    public boolean isOpen(int row, int col) {
        if(!isInputInBounds(row, col)) throw new IndexOutOfBoundsException();
        int index = calculateIndex(row, col);
        return array[index] != BLOCKED_SITE;
    }

    private int calculateIndex(int row, int col) {
        return (row - 1) * size + (col - 1);
    }

    public boolean isFull(int row, int col) {
        return true;
    }

    public boolean percolates() {
        return true;
    }

    public static void main(String[] args) {

    }

    private boolean isInputInBounds(int row, int col) {
        return isRowIndexInBounds(row) && isColIndexInBounds(col);
    }

    private boolean isRowIndexInBounds(int row) {
        return row < size && row > -1;
    }

    private boolean isColIndexInBounds(int col) {
        return col < size && col > -1;
    }
}
