import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] distFire, distJ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);
        map = new char[R][C];
        distFire = new int[R][C];
        distJ = new int[R][C];
        Queue<Pair> queueFire = new LinkedList<>();
        Queue<Pair> queueJ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(distFire[i], -1);
            Arrays.fill(distJ[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    queueFire.add(new Pair(i, j));
                    distFire[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    queueJ.add(new Pair(i, j));
                    distJ[i][j] = 0;
                }
            }
        }

        spreadFire(queueFire);
        escapeMaze(queueJ);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((i == 0 || j == 0 || i == R - 1 || j == C - 1) && distJ[i][j] != -1) {
                    result = Math.min(result, distJ[i][j]);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? "IMPOSSIBLE" : result + 1);
    }

    static void spreadFire(Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (distFire[nx][ny] == -1 && map[nx][ny] != '#') {
                        distFire[nx][ny] = distFire[now.x][now.y] + 1;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    static void escapeMaze(Queue<Pair> queue) {
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (distJ[nx][ny] == -1 && map[nx][ny] != '#') {
                        if (distFire[nx][ny] == -1 || distJ[now.x][now.y] + 1 < distFire[nx][ny]) {
                            distJ[nx][ny] = distJ[now.x][now.y] + 1;
                            queue.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
