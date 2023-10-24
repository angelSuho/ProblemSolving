import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int side = Math.min(N, M);
        while (side >= 1) {
            for (int i = 0; i <= N - side; i++) {
                for (int j = 0; j <= M - side; j++) {
                    if (checkSquare(arr, i, j, side)) {
                        System.out.println(side * side);
                        return;
                    }
                }
            }
            side--;
        }
    }

    private static boolean checkSquare(String[] arr, int x, int y, int side) {
        char x1 = arr[x].charAt(y);
        char y1 = arr[x].charAt(y + side - 1);
        char x2 = arr[x + side - 1].charAt(y);
        char y2 = arr[x + side - 1].charAt(y + side - 1);
        return x1 == y1 && y1 == x2 && x2 == y2;
    }
}