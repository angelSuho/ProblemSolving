import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] strings = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] points = queue.poll();
            int x = points[0];
            int y = points[1];
            int cnt = points[2];
            int isBreak = points[3];

            if (x == N - 1 && y == M - 1) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == 0 && !visited[nx][ny][isBreak]) {
                    visited[nx][ny][isBreak] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, isBreak});
                }
                if (arr[nx][ny] == 1 && isBreak == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new int[]{nx, ny, cnt + 1, 1});
                }
            }
        }

        return -1;
    }
}
