import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];

        dp[1] = 0;
        if (n > 1) {
            dp[2] = 1;
        }

        // 교란 순열
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1000000000;
        }

        System.out.println(dp[n]);
    }
}