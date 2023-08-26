import java.io.*;

public class Main {

    static long[] dpA;
    static long[] dpB;

    private static void solution(int k) {
        if(k > 0) {
            dpA[1] = 0;
            dpB[1] = 1;
        }

        for (int i = 2; i <= k; i++) {
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(bf.readLine());

        dpA = new long[k + 1];
        dpB = new long[k + 1];

        solution(k);

        System.out.println(dpA[k] + " " + dpB[k]);
    }
}