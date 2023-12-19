import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int sumHeight = 0;
        int oddCnt = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            sumHeight += tree;
            if (tree % 2 == 1) {
                oddCnt++;
            }
        }


        calculateLength(sumHeight, oddCnt);
    }

    private static void calculateLength(int sumHeight, int oddCnt) {
        if(sumHeight % 3 == 0 && oddCnt <= sumHeight / 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}