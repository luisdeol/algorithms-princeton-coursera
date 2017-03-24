package com.luisdeol;

public class Main {

    public static void main(String[] args) {
	// write your code here
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(0,1);
        uf.union(2,1);
        uf.union(3,4);
        uf.union(3,2);

        System.out.println(uf.connected(4,1));
        System.out.println(uf.connected(3,1));
        System.out.println(uf.connected(5,1));
    }
}
