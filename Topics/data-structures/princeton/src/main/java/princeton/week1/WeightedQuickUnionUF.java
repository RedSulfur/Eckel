package princeton.week1;

public class WeightedQuickUnionUF {

    private int[] id;
    private int count;
    private int[] sz;

    public WeightedQuickUnionUF(int N) {

        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {

        int pRoot = find(p);
        System.out.println("pRoot = " + pRoot);
        int qRoot = find(q);
        System.out.println("qRoot = " + qRoot);

        if(pRoot == qRoot) return;

        if(sz[pRoot] < sz[qRoot]) {
            System.out.println("In if:");
            id[pRoot] = qRoot;
            System.out.println("sz[qRoot] = " + sz[qRoot]);
            sz[qRoot] += sz[pRoot];
            System.out.println("After gaining weight sz[pRoot] = " + sz[pRoot]);
        } else {
            System.out.println("In else:");
            id[qRoot] = pRoot;
            System.out.println("sz[pRoot] = " + sz[pRoot]);
            sz[pRoot] += sz[qRoot];
            System.out.println("After gaining weight sz[pRoot] = " + sz[pRoot]);
        }
        count--;
    }
}