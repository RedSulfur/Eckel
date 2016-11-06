package princeton.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int     NUMBER_OF_VIRTUAL_SITES = 2;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][]          opened;
    private final int            n;
    private int                  virtualTop;
    private int                  virtualBotSite;

    public Percolation(int N) {
        if(N <= 0) throw new IllegalArgumentException("Some interstellar stuff is going on");
        this.n = N;
        opened = new boolean[N][N];
        int oneDimensionalArraySize = N * N + NUMBER_OF_VIRTUAL_SITES;
        weightedQuickUnionUF = new WeightedQuickUnionUF(oneDimensionalArraySize);
        virtualBotSite = N * N - 1;
        virtualTop = N * N;
    }

    public void open(int row, int col) {

        int index = calculateIndex(row, col);

        int rowIndex = row - 1;
        int colIndex = col - 1;

        if (row == 1) weightedQuickUnionUF.union(index, virtualTop);
        if (row == n) weightedQuickUnionUF.union(index, virtualBotSite);

        opened[rowIndex][colIndex] = true;

        if (row != 1 && opened[rowIndex - 1][colIndex]) {
            weightedQuickUnionUF.union(index, index - n);
        }
        if (col != 1 && opened[rowIndex][colIndex - 1]) {
            weightedQuickUnionUF.union(index, index - 1);
        }
        if (col != n && opened[rowIndex][colIndex + 1]) {
            weightedQuickUnionUF.union(index, index + 1);
        }
        if (row != n && opened[rowIndex + 1][colIndex]) {
            weightedQuickUnionUF.union(index, index + n);
        }
    }

    public int find(int row, int col) {
        int index = calculateIndex(row, col);
        return weightedQuickUnionUF.find(index);
    }

    public boolean isOpen(int row, int col) {
        int rowIndex = row - 1;
        int colIndex = col - 1;
        if(!isInputInBounds(rowIndex, colIndex)) throw new IndexOutOfBoundsException();
        return opened[rowIndex][colIndex];
    }

    public boolean isFull(int row, int col) {
        int index = calculateIndex(row, col);
        int rowIndex = row - 1;
        int colIndex = col - 1;
        if(!isInputInBounds(rowIndex, colIndex)) throw new IndexOutOfBoundsException();
        return weightedQuickUnionUF.find(index) == weightedQuickUnionUF.find(virtualTop);
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(virtualBotSite, virtualTop);
    }

    private int calculateIndex(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    public static void main(String[] args) {

    }

    private boolean isInputInBounds(int row, int col) {
        return isRowIndexInBounds(row) && isColIndexInBounds(col);
    }

    private boolean isRowIndexInBounds(int row) {
        return row < n && row > -1;
    }

    private boolean isColIndexInBounds(int col) {
        return col < n && col > -1;
    }
}
