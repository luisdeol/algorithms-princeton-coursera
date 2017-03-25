package com.luisdeol;

public class Main {

    public static void main(String[] args) {
	// write your code here
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(1,2);
        uf.union(2, 3);
        uf.union(5,6);
        uf.union(5,7);
        uf.union(3,6);

        System.out.println("Number of objectsin the root index 1:" + uf.sz[1]);
        System.out.println("Number of objectsin the root index 5:" + uf.sz[1]);


    }
}
