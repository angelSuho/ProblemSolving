import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][][] box;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[H][M][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    box[h][m][n] = Integer.parseInt(st.nextToken());
                    if (box[h][m][n] == 1) {
                        queue.add(new int[]{h, m, n});
                    }
                }
            }
        }

        int days = bfs(queue);

        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (box[h][m][n] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(days);
    }

    static int bfs(Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int h = pos[0];
                int y = pos[1];
                int x = pos[2];

                for (int dir = 0; dir < 6; dir++) {
                    int nh = h + dh[dir];
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (nh >= 0 && nh < H && ny >= 0 && ny < M && nx >= 0 && nx < N) {
                        if (box[nh][ny][nx] == 0) {
                            box[nh][ny][nx] = 1;
                            queue.add(new int[]{nh, ny, nx});
                        }
                    }
                }
            }
        }

        return days;
    }
}
