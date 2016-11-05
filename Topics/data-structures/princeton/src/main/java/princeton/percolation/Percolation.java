package princeton.percolation;

import princeton.WeightedQuickUnionUF;

public class Percolation {

    private static final int     NUMBER_OF_VIRTUAL_SITES = 2;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][]          opened;
    private final int            N;
    private int                  VIRTUAL_TOP_SITE;
    private int                  VIRTUAL_BOT_SITE;

    public Percolation(int N) {
        if(N <= 0) throw new IllegalStateException("Some interstellar stuff is going on");
        this.N = N;
        opened = new boolean[N][N];
        int oneDimensionalArraySize = N * N + NUMBER_OF_VIRTUAL_SITES;
        weightedQuickUnionUF = new WeightedQuickUnionUF(oneDimensionalArraySize);
        VIRTUAL_BOT_SITE = N * N - 1;
        VIRTUAL_TOP_SITE = N * N;
    }

    public void open(int row, int col) {

        int index = calculateIndex(row, col);

        int rowIndex = row - 1;
        int colIndex = col - 1;

        if(row == 1) weightedQuickUnionUF.union(index, VIRTUAL_TOP_SITE);
        if(row == N) weightedQuickUnionUF.union(index, VIRTUAL_BOT_SITE);

        opened[rowIndex][colIndex] = true;

        if(row != 1 && opened[rowIndex - 1][colIndex]) {
            weightedQuickUnionUF.union(index, index - N);
        }
        if(col != 1 && opened[rowIndex][colIndex - 1]) {
            weightedQuickUnionUF.union(index, index - 1);
        }
        if(col != N && opened[rowIndex][colIndex + 1]) {
            weightedQuickUnionUF.union(index, index + 1);
        }
        if(row != N && opened[rowIndex + 1][colIndex]) {
            weightedQuickUnionUF.union(index, index + N);
        }
    }

    private int find(int row, int col) {
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
        return weightedQuickUnionUF.find(index) == weightedQuickUnionUF.find(VIRTUAL_TOP_SITE);
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(VIRTUAL_BOT_SITE, VIRTUAL_TOP_SITE);
    }

    private int calculateIndex(int row, int col) {
        return (row - 1) * N + (col - 1);
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
