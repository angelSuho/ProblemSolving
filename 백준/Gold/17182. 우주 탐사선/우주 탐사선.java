import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int[][] travelTime;
    private static boolean[] visited;
    private static int N;
    private static int minValue = Integer.MAX_VALUE;

    public static void explorePlanet(int currentPlanet, int planet, int time) {
        if (time > minValue) {
            return;
        }
        if (planet == N) {
            minValue = Math.min(minValue, time);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next]) {
                visited[next] = true;
                explorePlanet(next, planet + 1, time + travelTime[currentPlanet][next]);
                visited[next] = false;
            }
        }
    }

    private static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (travelTime[i][j] > travelTime[i][k] + travelTime[k][j]) {
                        travelTime[i][j] = travelTime[i][k] + travelTime[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int startPlanet = Integer.parseInt(st.nextToken());
        travelTime = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                travelTime[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 행성 간의 최단 거리 초기화
        floydWarshall();

        // 시작 행성을 방문 처리
        visited[startPlanet] = true;
        explorePlanet(startPlanet, 1, 0);

        System.out.println(minValue);
        bf.close();
    }
}
