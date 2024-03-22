import java.io.*;
import java.util.*;

public class Main {

    private static int M, N;
    private static int[][] map;
    private static int[][] dp;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(searchCourseByDfs(0, 0));
    }

    private static int searchCourseByDfs(int x, int y) {
        if (x == N-1 && y == M-1) return 1;
        if (dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[y][x] > map[ny][nx]) {
                dp[y][x] += searchCourseByDfs(nx, ny);
            }
        }

        return dp[y][x];
    }
}
