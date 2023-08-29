import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N, M;
    static int[][] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        bruteForce(0, 0);
        System.out.println(count);
    }

    public static void bruteForce(int x, int y) {
        if (x == N) {
            if (!isNeaMoSquare()) {
                count++;
            }
            return;
        }

        board[x][y] = 0;
        if (y + 1 < M) bruteForce(x, y + 1);
        else bruteForce(x + 1, 0);

        board[x][y] = 1;
        if (y + 1 < M) bruteForce(x, y + 1);
        else bruteForce(x + 1, 0);
    }

    public static boolean isNeaMoSquare() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j] == 1 && board[i + 1][j + 1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}





