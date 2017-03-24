package com.luisdeol;

/**
 * Created by luisdeol on 24/03/17.
 */
public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int n){
        id = new int[n];
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    private int root(int p){
        while(p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected (int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        id[rootP] = rootQ;
    }
}