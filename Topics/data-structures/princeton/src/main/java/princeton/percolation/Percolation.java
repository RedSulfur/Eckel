package princeton.percolation;

public class Percolation {

    private static final int BLOCKED_SITE = -1;

    private int virtualTop;
    private int virtualBottom;
    private int[] array;
    private int size;

    public Percolation(int n) {
        size = n;
        array = new int[size * size];

        for (int i = 0; i < size * size; i++) {
            array[i] = BLOCKED_SITE;
        }
    }

    public void open(int row, int col) {
        int index = calculateIndex(row, col);
        if(array[index - size] == BLOCKED_SITE) {
            union(index, index - size);
        }
        if(array[index - size] == BLOCKED_SITE) {
            union(index, index - size);
        }
        if(array[index - size] == BLOCKED_SITE) {
            union(index, index - size);
        }
        if(array[index - size] == BLOCKED_SITE) {
            union(index, index - size);
        }
    }

    private void union(int i, int j) {

    }

    public boolean isOpen(int row, int col) {
        if(!isInputInBounds(row, col)) throw new IndexOutOfBoundsException();
        int index = calculateIndex(row, col);
        return true;
    }

    private int calculateIndex(int row, int col) {
        return (row - 1) * size + col;
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
        return row < size - 1 && row > -1;
    }

    private boolean isColIndexInBounds(int col) {
        return col < size - 1 && col > -1;
    }
}
