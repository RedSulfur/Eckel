package princeton;

public class QuickFind {

    private int[] id;
    private int count;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int count() {
        return count;
    }

    // the quickest find implementation
    public int find(int p) {
        return id[p];
    }

    // between N + 3 and 2N + 1 array accesses for each call to union
    // complexity of the following union implementation is N^2
    public void union(int p, int q) {

        // 2 calls to find
        int pId = find(p);
        int qId = find(q);

        // test each of N entries in array and changes from 1 to N - 1 of them
        if(pId == qId) return;

        // N + 2 + 1 = N + 3
        // N - 1 + 2 = N + 1
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pId) id[i] = qId;
        }
        count--;
    }
}