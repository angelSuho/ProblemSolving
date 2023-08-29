import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int idx = 0; idx < n; idx++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N + M];

            st = new StringTokenizer(bf.readLine());
            makeArr(st);

            int count = slidingWindow();
            System.out.println(count);
        }
    }

    private static void makeArr(StringTokenizer st) {
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N; i < N + M; i++) {
            arr[i] = arr[i - N];
        }
    }

    private static int slidingWindow() {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum += arr[i];
        }
        if (sum < K) {
            count++;
        }
        if (!(N == M)) {
            for (int i = M; i < N + M - 1; i++) {
                sum += arr[i];
                sum -= arr[i - M];
                if (sum < K) {
                    count++;
                }
            }
        }
        return count;
    }
}
