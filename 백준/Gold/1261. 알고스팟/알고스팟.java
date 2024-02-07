import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    // 벽을 부순 개수
    int cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    // priorityQueue를 사용할 때, 벽을 부순 개수를 기준으로 정렬하기 위해 compareTo를 오버라이딩.
    @Override
    public int compareTo(Point o) {
        return this.cnt - o.cnt;
    }
}

public class Main {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N, M;
    static int[][] maze;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maze = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = bf.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = input.charAt(j - 1) - '0';
            }
        }

        // 현재 위치부터 bfs
        System.out.println(AOJ(1, 1));
        bf.close();
    }

    public static int AOJ(int x, int y) {
        // 벽을 부순 개수를 오름차순으로 정렬하도록 설정.
        PriorityQueue<Point> q = new PriorityQueue<>();

        q.offer(new Point(x, y, 0));
        boolean[][] visit = new boolean[N + 1][M + 1];
        visit[x][y] = true;

        int nx, ny;
        while (!q.isEmpty()) {
            Point p = q.poll();

            // 도착점에 도달했으면 종료.
            if (p.x == N && p.y == M) {
                return p.cnt;
            }

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];
                
                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    // 벽이 있다면 cnt를 1 증가시키고, 없다면 기존 cnt를 유지
                    // 0: 벽이 없는 경우, 1: 벽이 있는 경우
                    q.offer(new Point(nx, ny, p.cnt + maze[nx][ny]));
                }
            }
        }
        return 0;
    }
}
