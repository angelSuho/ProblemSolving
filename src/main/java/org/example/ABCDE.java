package org.example;

import java.util.*;

public class ABCDE {

    static Scanner sc = new Scanner(System.in);

    private static final ArrayList<ArrayList<Integer>> list = new ArrayList<>();;
    private static boolean[] visit;

    public static void main(String[] args)  {

        int n = sc.nextInt();
        int m = sc.nextInt();
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i);
        }
        System.out.println(0);
    }
    private static void dfs(int num, int idxs) {
        if(num == 5) {
            System.out.print(1);
            System.exit(0);
        }
        for(int idx : list.get(idxs)) {
            if(!visit[idx]) {
                visit[idx] = true;
                dfs(num + 1, idx);
                visit[idx] = false;
            }
        }
    }
}
