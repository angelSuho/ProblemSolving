 package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 리모컨 {
    static boolean[] broken = new boolean[11];
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(bf.readLine());
        int brokenNum = Integer.parseInt(bf.readLine());

        int result = Math.abs(n - 100);
        System.out.println(result);

        if (brokenNum == 0) {
            if (n == 0) {
                System.out.println(0);
                return;
            } else {
                String s = String.valueOf(n);
                System.out.println(s.length());
                return;
            }
        }

        int[] s = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int idx : s) {
            broken[idx] = true;
        }

        for (int idx = 0; idx < 1000000; idx++) {

            int lgth = getLength(idx);
            boolean isTrue = false;

            for(int j = 0; j < lgth; j++) {
                if(broken[getAnInt(idx, j)]) {
                    isTrue = true; break;
                }
            }
            if(!isTrue) {
                result = Math.min(Math.abs(n - idx) + lgth, result);
            }
        }
        System.out.println(result);
    }

    private static int getAnInt(int idx, int j) {
        return (idx / (int) Math.pow(10, j)) % 10;
    }

    private static int getLength(int idx) {
        return String.valueOf(idx).length();
    }
}
