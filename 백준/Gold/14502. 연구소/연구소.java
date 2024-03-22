import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(maxSafeArea(arr));
    }

    private static int maxSafeArea(int[][] arr) {
        List<int[]> emptySpaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        int maxSafe = 0;
        for (int i = 0; i < emptySpaces.size(); i++) {
            for (int j = i + 1; j < emptySpaces.size(); j++) {
                for (int k = j + 1; k < emptySpaces.size(); k++) {
                    int[][] tempLab = new int[n][m];
                    for (int a = 0; a < n; a++) {
                        System.arraycopy(arr[a], 0, tempLab[a], 0, m);
                    }

                    tempLab[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 1;
                    tempLab[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 1;
                    tempLab[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 1;

                    maxSafe = Math.max(maxSafe, searchSafeZoneByBfs(tempLab));
                }
            }
        }

        return maxSafe;
    }

    private static int searchSafeZoneByBfs(int[][] lab) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && lab[nx][ny] == 0) {
                    lab[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    safe++;
                }
            }
        }
        return safe;
    }
}
