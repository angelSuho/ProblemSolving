import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean[] visited;
    static int[][] arr;
    static int n, m, a, b, rlt = 0;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            rlt = 0;
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+1][n+1];
            visited = new boolean[n+1];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                arr[a][b]=1; arr[b][a]=1;
            }

            bfs();
            sb.append((rlt - 1)).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()) {
            rlt++;
            int tmp = q.poll();
            for (int i = 1; i <= n; i++) {
                if(arr[tmp][i]!=0 && !visited[i]) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}