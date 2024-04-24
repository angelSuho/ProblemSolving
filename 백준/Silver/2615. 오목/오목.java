import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static final int SIZE = 19;
    private static final int[] dx = {0, 1, 1, -1};
    private static final int[] dy = {1, 0, 1, 1};
    private static boolean isTrue = false;

    private static int[] calculateWinner(int[][] board) {
        int[] answer = new int[] {0};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    for (int idx = 0; idx < 4; idx++) {
                        answer = checkFiveDot(i, j, dx[idx], dy[idx], board);
                        if (answer[0] != 0 || isTrue) {
                            return answer;
                        }
                    }
                }
            }
        }

        return answer;
    }

    // (x, y) 위치에서 dx, dy 방향으로 5개의 돌이 연속되어 있는지 확인
    private static int[] checkFiveDot(int x, int y, int dx, int dy, int[][] board) {
        int dotCnt = 1;
        int dotColor = board[x][y];
        int nx = x + dx;
        int ny = y + dy;

        // 정방향으로 연속된 돌
        while (isSizeValid(nx, ny) && board[nx][ny] == dotColor) {
            dotCnt++;
            nx += dx;
            ny += dy;
        }

        nx = x - dx;
        ny = y - dy;
        // 정방향으로 연속된 돌이 5개인 경우
        if (dotCnt == 5) {
            if(isSizeValid(nx,ny)&&board[nx][ny]==dotColor){
                return new int[] {0};
            }
            isTrue = true;
            return new int[] {dotColor, x + 1, y + 1};
        }

        // 5개의 돌이 연속되어 있지 않은 경우
        return new int[] {0};
    }

    private static boolean isSizeValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public static void main(String[] args) throws IOException {
        int[][] board = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = calculateWinner(board);
        if (result[0] != 0) {
            System.out.println(result[0]);
            System.out.println(result[1] + " " + result[2]);
        } else {
            System.out.println(0);
        }
    }
}
