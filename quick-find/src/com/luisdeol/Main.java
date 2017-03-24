package com.luisdeol;

public class Main {

    public static void main(String[] args) {
	// write your code here
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(1,2);
        uf.union(2,3);
        System.out.println(uf.connected(1,3));
    }
}
