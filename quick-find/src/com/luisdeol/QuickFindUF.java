package com.luisdeol;

/**
 * Created by luisdeol on 24/03/17.
 */
public class QuickFindUF
{
    public int[] id;

    public QuickFindUF(int n){
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        if (!connected(p, q)){
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < id.length; i++){
                if (id[i]== pid)
                    id[i] = qid;
            }
        }
    }
}
