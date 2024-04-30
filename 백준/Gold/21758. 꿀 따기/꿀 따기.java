import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());
        int[] honey = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        // 꿀통 벌 벌
        int leftMostHoney = getLeftMostHoney(N, honey);
        // 벌 벌 꿀통
        int rightMostHoney = getRightMostHoney(N, honey);
        // 벌 꿀통 벌
        int middleHoney = getMiddleHoney(N, honey);

        // 세 경우 중 최대값 출력
        int maxHoney = Math.max(leftMostHoney, Math.max(rightMostHoney, middleHoney));
        System.out.println(maxHoney);
    }

    private static int getLeftMostHoney(int N, int[] honey) {
        int[] sum = new int[honey.length];

        // 현재지점을 제외한 뒤의 꿀의 합
        for (int i = honey.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + honey[i + 1];
        }
        int totalHoney = sum[0];

        int maxHoney = 0;
        // 0번째는 벌통의 위치
        for (int i = 1; i < honey.length; i++) {
            // 벌들의 위치들을 제외한 꿀 최대값
            maxHoney = Math.max(maxHoney, totalHoney - honey[i] + sum[i]);
        }

        return maxHoney;
    }

    private static int getRightMostHoney(int N, int[] honey) {
        int[] sum = new int[honey.length];

        for (int i = 1; i < honey.length; i++) {
            sum[i] = sum[i - 1] + honey[i - 1];
        }
        int totalHoney = sum[honey.length - 1];

        int maxHoney = 0;
        for (int i = 0; i < honey.length - 1; i++) {
            maxHoney = Math.max(maxHoney, totalHoney - honey[i] + sum[i]);
        }

        return maxHoney;
    }

    private static int getMiddleHoney(int N, int[] honey) {
        int[] leftSum = new int[honey.length];
        int[] rightSum = new int[honey.length];

        // 왼쪽 누적합
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] + honey[i];
        }

        // 오른쪽 누적합
        for (int i = rightSum.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + honey[i];
        }

        int maxHoney = 0;
        for (int i = 0; i < honey.length; i++) {
            // 현재 지점까지 벌들의 위치를 제외한 꿀의 최대값
            maxHoney = Math.max(maxHoney, leftSum[i] + rightSum[i]);
        }

        return maxHoney;
    }
}
