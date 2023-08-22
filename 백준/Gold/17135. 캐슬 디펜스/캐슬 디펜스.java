import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board, copyBoard;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        copyBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0, new int[3]);
        System.out.println(max);
    }

    static void comb(int idx, int count, int[] archers) {
        if (count == 3) {
            for (int i = 0; i < N; i++) {
                copyBoard[i] = board[i].clone();
            }
            max = Math.max(max, simulate(archers));
            return;
        }

        if (idx == M) return;
        
        archers[count] = idx;
        comb(idx + 1, count + 1, archers);
        comb(idx + 1, count, archers);
    }

    static int simulate(int[] archers) {
        int killed = 0;

        while (!isAllClear()) {
            Set<int[]> target = new HashSet<>();

            for (int a : archers) {
                int minDist = D + 1;
                int targetX = -1, targetY = -1;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (copyBoard[i][j] == 1) {
                            int dist = Math.abs(N - i) + Math.abs(a - j);
                            if (dist <= D) {
                                if (dist < minDist || (dist == minDist && j < targetY)) {
                                    targetX = i;
                                    targetY = j;
                                    minDist = dist;
                                }
                            }
                        }
                    }
                }

                if (targetX != -1 && targetY != -1) {
                    target.add(new int[] {targetX, targetY});
                }
            }

            for (int[] t : target) {
                int x = t[0], y = t[1];
                if (copyBoard[x][y] == 1) {
                    killed++;
                    copyBoard[x][y] = 0;
                }
            }
            
            moveEnemies();
        }

        return killed;
    }

    static void moveEnemies() {
        for (int i = N - 1; i > 0; i--) {
            copyBoard[i] = copyBoard[i - 1].clone();
        }
        Arrays.fill(copyBoard[0], 0);
    }

    static boolean isAllClear() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyBoard[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}