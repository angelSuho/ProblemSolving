public class Solution {
    public int solution(int [][]board) {
        int maxSide = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    maxSide = 1; // 적어도 1x1 크기의 정사각형이 존재함
                }
            }
        }

        // 나머지 칸 확인
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    int side = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                    board[i][j] = side; // 이 값을 현재 칸에 기록
                    maxSide = Math.max(maxSide, side); // 최대 한 변의 길이 갱신
                }
            }
        }

        // 최대 정사각형의 넓이 반환
        return maxSide * maxSide;
    }
}
