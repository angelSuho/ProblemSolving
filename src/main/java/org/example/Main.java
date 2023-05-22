package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] field = new int[m + 1][n + 1];
        for(int[] arr : field) {
            Arrays.fill(arr, 0);
        }
        field[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                if (isInPuddles(i, j, puddles)) field[i][j] = 0;
                else field[i][j] = (field[i - 1][j] + field[i][j - 1]) % 1000000007;
            }
        }
        return field[m][n];
    }

    public static boolean isInPuddles(int x, int y, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[0] == x && puddle[1] == y) return true;
        }
        return false;
    }
}