package com.luisdeol;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Created by luisdeol on 25/03/17.
 */

public class UnionFind {
    private static final String fileName = "friendships.csv";
    int id[];
    int friendNetwork[];
    int length;

    public UnionFind(int n){
        id = new int[n];
        friendNetwork = new int[n];
        length = n;
        for (int i = 0; i < n; i++){
            id[i] = i;
            friendNetwork[i] = 1;
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
        if (friendNetwork[rootP] < friendNetwork[rootQ]){

            id[rootP] = rootQ;
            friendNetwork[rootQ] += friendNetwork[rootP];
            CsvReaderAndWriter.WriteCsvFile(fileName, p, q);
        }
        else {
            id[rootQ] = rootP;
            friendNetwork[rootP] += friendNetwork[rootQ];

            CsvReaderAndWriter.WriteCsvFile(fileName, p, q);
        }
    }

    public boolean allConnected(){
        IntSummaryStatistics stat = Arrays.stream(friendNetwork).summaryStatistics();
        return stat.getMax()== length;
    }
}
