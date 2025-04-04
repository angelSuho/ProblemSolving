import java.util.*;
import java.io.*;

public class Main {

    private static final int[][] board = new int[5][5];
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        gen_input_board(bf);
        calculate_correct_answer(bf);
    }

    private static void gen_input_board(BufferedReader bf) throws IOException {
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calculate_correct_answer(BufferedReader bf) throws IOException {
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                int call_num = Integer.parseInt(st.nextToken());
                change_board_num(call_num);
                if (is_three_bingo()) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    private static void change_board_num(int call_num) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (board[x][y] == call_num) {
                    count++;
                    board[x][y] = -1;
                    break;
                }
            }
        }
    }

    private static boolean is_three_bingo() {
        int bingo_count = 0;

        // 세로
        for (int i = 0; i < 5; i++) {
            boolean row_bingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1) {
                    row_bingo = false;
                    break;
                }
            }
            if (row_bingo) {
                bingo_count++;
            }
        }

        // 가로
        for (int j = 0; j < 5; j++) {
            boolean col_bingo = true;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] != -1) {
                    col_bingo = false;
                    break;
                }
            }
            if (col_bingo) {
                bingo_count++;
            }
        }

        // 대각선
        boolean diag1_bingo = true;
        boolean diag2_bingo = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                diag1_bingo = false;
            }
            if (board[i][4 - i] != -1) {
                diag2_bingo = false;
            }
        }
        if (diag1_bingo) {
            bingo_count++;
        }
        if (diag2_bingo) {
            bingo_count++;
        }

        return bingo_count >= 3;
    }
}
