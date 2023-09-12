import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] time = getAccumulatedTime(n);
        List<Integer> result = findBestStudyTime(time, t);

        System.out.println(result.get(0) + " " + result.get(1));
    }

    private static int[] getAccumulatedTime(int n) throws IOException {
        int[] time = new int[100001];

        for (int i = 0; i < n; i++) {
            int K = Integer.parseInt(bf.readLine());
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                time[start]++;
                time[end]--;
            }
        }

        for (int i = 1; i < time.length; i++) {
            time[i] += time[i - 1];
        }

        return time;
    }

    private static List<Integer> findBestStudyTime(int[] time, int t) {
        int windowSum = 0;

        for (int i = 0; i < t; i++) {
            windowSum += time[i];
        }
        int maxSum = windowSum;

        int maxStartTime = 0;
        for (int i = t; i < time.length; i++) {
            windowSum = windowSum - time[i - t] + time[i];
            if (windowSum > maxSum) {
                maxSum = windowSum;
                maxStartTime = i - t + 1;
            }
        }

        return List.of(maxStartTime, maxStartTime + t);
    }
}