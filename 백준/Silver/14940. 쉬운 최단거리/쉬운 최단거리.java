import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] visited;
    private static int[][] arr;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        searchingWayToTarget();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void searchingWayToTarget() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    bfs(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && arr[i][j] != 0 && arr[i][j] != 2) {
                    visited[i][j] = -1;
                }
            }
        }
    }

    private static void bfs(int x_idx, int y_idx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x_idx, y_idx});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            int[] points = queue.poll();
            int x = points[0];
            int y = points[1];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];
                if ((nx >= 0 && ny >= 0 && nx < n && ny < m) && visited[nx][ny] == 0 && arr[nx][ny] != 0 && !(nx == x_idx && ny == y_idx)) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
