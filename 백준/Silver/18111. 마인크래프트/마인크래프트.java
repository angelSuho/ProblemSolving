import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int B;
    private static final int[] heightCounts = new int[257];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int minLevel = 256;
        int maxLevel = 0;

        // 높이 정보 입력 및 최소/최대 높이 계산
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(st.nextToken());
                heightCounts[height]++;
                if (height < minLevel) minLevel = height;
                if (height > maxLevel) maxLevel = height;
            }
        }

        int optimalTime = Integer.MAX_VALUE;
        int optimalHeight = -1;

        // 가능한 높이 범위에서 최적의 높이와 시간을 찾음
        for (int targetHeight = minLevel; targetHeight <= maxLevel; targetHeight++) {
            int time = calculateTime(targetHeight);
            if (time <= optimalTime) {
                optimalTime = time;
                optimalHeight = targetHeight;
            }
        }

        System.out.println(optimalTime + " " + optimalHeight);
    }

    private static int calculateTime(int targetHeight) {
        int time = 0;
        int inventory = B;

        for (int h = 0; h < heightCounts.length; h++) {
            if (heightCounts[h] > 0) {
                int diff = h - targetHeight;
                if (diff > 0) {
                    time += diff * 2 * heightCounts[h];
                    inventory += diff * heightCounts[h];
                } else if (diff < 0) {
                    time -= diff * heightCounts[h];
                    inventory += diff * heightCounts[h];
                }
            }
        }

        return inventory >= 0 ? time : Integer.MAX_VALUE;
    }
}
