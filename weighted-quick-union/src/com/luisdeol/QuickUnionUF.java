package com.luisdeol;

/**
 * Created by luisdeol on 25/03/17.
 */
public class QuickUnionUF {
    int[] id;
    int[] sz;
    public QuickUnionUF(int n){
        id = new int[n];
        sz = new int[n];

        for (int i = 0; i < n-1; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int p){
        while(p != id[p])
            p = id[p];

        return p;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;

        if (sz[rootP] < sz[rootQ]) { id[rootP] = rootQ; sz[rootQ] += sz[rootP]; }
        else { id[rootQ] = rootP; sz[rootP] += sz[rootQ]; }
    }
}
