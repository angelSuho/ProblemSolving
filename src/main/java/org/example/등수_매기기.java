package org.example;

import java.io.*;
import java.util.*;

public class 등수_매기기 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] lst = new int[n + 1];
        long sillmang = 0;

        lst[0] = 0;
        for (int i = 1; i <= n; i++) {
            lst[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lst);

        for (int i = 1; i <= n; i++) {
            sillmang += Math.abs(i-lst[i]);
        }

        System.out.println(sillmang);
    }
}