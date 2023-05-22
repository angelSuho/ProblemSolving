package org.example;

import java.util.Arrays;
class exam {
    public int solution (int width, int height, int[][] diagonals) {
        int answer = 0;
        int [][] dp = new int [width] [height];
        fillArrays (dp, height);
        for (int[] diagonal: diagonals) {
            for (int i = 0; i < width; i++) {
                for (int j = height-1; j >= 0; j--) {
                    if (i == 0 && j == height-1) {
                        continue;
                    }
                    dpCheck(dp, diagonal, i, j, height);
                }
            }
            answer += dp[width-1][0];
        }

        return answer;
    }

    private void fillArrays (int[][] dp, int height) {
        for (int[] x: dp) {
            Arrays.fill(x, 0);
            dp[0][height-1] = 1;
        }
    }

    private void dpCheck(int[][] dp, int[] diagonal, int i, int j, int height) {
        if (i == diagonal[0]-1 && j == diagonal[1]-1) {
            checkIndex(dp, i, j, height);
            dp[i][j] += 2;
        } else {
            checkIndex(dp, i, j, height);
        }
    }

    private void checkIndex(int[][] dp, int i, int j, int height) {
        if (i == 0) {
             dp[i][j] = dp[i][j+1];
            return;
        }
        if (j == height-1) {
             dp[i][j] = dp[i-1][j];
            return;
        }
        dp[i][j] = dp[i - 1][j] + dp[i][j + 1];
    }

    public static void main(String[] args) {
        System.out.println(new exam().solution(2, 2, new int[][]{{1, 1}, {2, 2}}));
    }
}
