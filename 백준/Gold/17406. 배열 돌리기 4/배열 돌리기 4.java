import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static class RotateStatus {
        private final int r;
        private final int c;
        private final int s;

        public RotateStatus(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }

        public List<int[]> generateRotateIndex() {
            int[] firstIdx = {r-s-1, c-s-1};
            int[] lastIdx = {r+s-1,c+s-1};
            return List.of(firstIdx, lastIdx);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<RotateStatus> rotateStatusList = new ArrayList<>();
         for (int i = 0; i < K; i++) {
             st = new StringTokenizer(bf.readLine());
             int r = Integer.parseInt(st.nextToken());
             int c = Integer.parseInt(st.nextToken());
             int s = Integer.parseInt(st.nextToken());
             rotateStatusList.add(new RotateStatus(r, c, s));
         }

        List<List<RotateStatus>> permutations = generatePermutations(new ArrayList<>(rotateStatusList), 0);
        int result = Integer.MAX_VALUE;
        for (List<RotateStatus> permutation : permutations) {
            int[][] tempArr = copyArray(N, M, arr);
            for (RotateStatus rotateStatus : permutation) {
                rotateArray(tempArr, rotateStatus);
            }
            result = Math.min(result, generateMinValueInArray(tempArr));
        }
        System.out.println(result);
    }

    private static int[][] copyArray(int N, int M, int[][] arr) {
        int[][] copyArr = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, copyArr[i], 0, M);
        }
        return copyArr;
    }

    private static void rotateArray(int[][] arr, RotateStatus status) {
        List<int[]> indexes = status.generateRotateIndex();
        int[] start = indexes.get(0);
        int[] end = indexes.get(1);

        for (int idx = 0; idx < status.s; idx++) {
            int top = start[0] + idx;
            int left = start[1] + idx;
            int bottom = end[0] - idx;
            int right = end[1] - idx;

            int temp = arr[top][left];

            for (int i = top; i < bottom; i++) arr[i][left] = arr[i + 1][left];
            for (int i = left; i < right; i++) arr[bottom][i] = arr[bottom][i + 1];
            for (int i = bottom; i > top; i--) arr[i][right] = arr[i - 1][right];
            for (int i = right; i > left; i--) arr[top][i] = arr[top][i - 1];

            arr[top][left + 1] = temp;
        }
    }

    private static int generateMinValueInArray(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int[] row : arr) {
            int sum = Arrays.stream(row).sum();
            min = Math.min(min, sum);
        }
        return min;
    }

    private static List<List<RotateStatus>> generatePermutations(List<RotateStatus> input, int start) {
        List<List<RotateStatus>> result = new ArrayList<>();
        if (start >= input.size()) {
            List<RotateStatus> singlePermutation = new ArrayList<>(input);
            result.add(singlePermutation);
        } else {
            for (int i = start; i < input.size(); i++) {
                Collections.swap(input, start, i);
                result.addAll(generatePermutations(input, start + 1));
                Collections.swap(input, start, i);
            }
        }
        return result;
    }
}
