import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int count = 0;

    static int[] kits;
    static boolean[] visited;

    static final int INIT_WEIGHT = 500;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, INIT_WEIGHT);
        System.out.println(count);
    }

    static void dfs(int day, int weight) {
        if (weight < 500) return;

        if (day == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(day + 1, weight - K + kits[i]);
                visited[i] = false;
            }
        }
    }
}