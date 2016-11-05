package princeton.percolation;

import princeton.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[] opened;
    private final int N;

    public Percolation(int N) {
        this.N = N;
        opened = new boolean[N * N];
        weightedQuickUnionUF = new WeightedQuickUnionUF(N);
    }

    public void open(int row, int col) {

        int index = calculateIndex(row, col);
        opened[index] = true;

        if(opened[index - N]) {
            weightedQuickUnionUF.union(index, index - N);
        }
        if(opened[index - 1]) {
            weightedQuickUnionUF.union(index, index - 1);
        }
        if(opened[index + 1]) {
            weightedQuickUnionUF.union(index, index + 1);
        }
        if(opened[index + N]) {
            weightedQuickUnionUF.union(index, index + N);
        }
    }



    //for testing purposes
    public int find(int row, int col) {
        int p = calculateIndex(row, col);
        if(array[p] == BLOCKED_SITE) return -1;
        while(p != array[p]) {
            p = array[p];
        }
        return p;
    }

    public boolean isOpen(int row, int col) {
        if(!isInputInBounds(row, col)) throw new IndexOutOfBoundsException();
        return opened[calculateIndex(row, col)];
    }

    private int calculateIndex(int row, int col) {
        return (row - 1) * N + (col - 1);
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
        return row < N && row > -1;
    }

    private boolean isColIndexInBounds(int col) {
        return col < N && col > -1;
    }
}
