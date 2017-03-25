package com.luisdeol;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UnionFind uf = new UnionFind(4);
        uf.union(0,1);
        uf.union(2,3);
        System.out.println("Is all connected?"+uf.allConnected());
    }
}
