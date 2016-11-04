package princeton;

public class QuickUnion {

    private int[] id;
    private int count;

    public QuickUnion (int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

    public int find(int p) {

        while (p != id[p]) p = id[p];

        return p;
    }
}