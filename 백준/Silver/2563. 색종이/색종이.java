import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final int REC_AREA = 100;
    private static final boolean[][] board = new boolean[101][101];
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if(!board[j][k])
                        board[j][k] = true;
                }
            }
        }

        for (int j = 1; j < REC_AREA; j++) {
            for (int k = 0; k < REC_AREA; k++) {
                if (board[j][k]) {
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
