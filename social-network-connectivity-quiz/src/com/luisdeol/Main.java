package com.luisdeol;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        UnionFind uf = new UnionFind(4);
        boolean allConnected = false;
        int a;
        int b;
        while(!allConnected){
            System.out.println("Friend 1");
            a = in.nextInt();
            System.out.println("Friend 2");
            b = in.nextInt();
            uf.union(a,b);
            if (uf.allConnected())
                allConnected = true;
        }
        System.out.println("All connected!");
    }
}
