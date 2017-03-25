package com.luisdeol;


import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Created by luisdeol on 25/03/17.
 */

public class UnionFind {
    private static final String fileName = "friendships.csv";
    int id[];
    int zs[];
    int length;

    public UnionFind(int n){
        id = new int[n];
        zs = new int[n];
        length = n;
        for (int i = 0; i < n; i++){
            id[i] = i;
            zs[i] = 1;
        }

    }

    public int root(int p){
        while (p != id[p])
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
        if (zs[rootP] < zs[rootQ]){

            id[rootP] = rootQ;
            zs[rootQ] += zs[rootP];
            System.out.println("zs do root" + Integer.toString(rootQ)+" é "+Integer.toString(zs[rootQ]));
            CsvReaderAndWriter.WriteCsvFile(fileName, p, q);
        }
        else {
            id[rootQ] = rootP;
            zs[rootP] += zs[rootQ];
            System.out.println("zs do root" + Integer.toString(rootP)+" é "+Integer.toString(zs[rootP]));

            CsvReaderAndWriter.WriteCsvFile(fileName, p, q);
        }
    }

    // Is it faster to compare all in an array to N or to find the max value then compare to N?
    public boolean allConnected(){
        IntSummaryStatistics stat = Arrays.stream(zs).summaryStatistics();
        System.out.println(stat.getMax());
        return stat.getMax()== length;
    }
}
