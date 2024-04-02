import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int N;

    public int solution(int[][] board) {
        N = board.length;
        return buildTrackByBfs(board);
    }

    private int buildTrackByBfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        // x,y 위치, 방향, 누적비용
        queue.offer(new int[]{0, 0, -1, 0});
        int[][][] accumCost = new int[N][N][4];

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0], y = tmp[1];
            int direction = tmp[2], cost =tmp[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {
                    int newCost = cost;
                    if (direction == -1 || direction == i) {
                        // 직선 방향으로 이동하는 경우
                        newCost += 100;
                    } else {
                        // 코너를 도는 경우, 코너 비용 + 직선 비용
                        newCost += 600;
                    }

                    // bfs로 갱신된 최소 비용 저장
                    if (accumCost[nx][ny][i] == 0 || accumCost[nx][ny][i] > newCost) {
                        accumCost[nx][ny][i] = newCost;
                        queue.offer(new int[]{nx, ny, i, newCost});
                    }
                }
            }
        }
        for (int i=0; i < accumCost.length; i++) {
            for (int j=0; j< accumCost[i].length; j++) {
                for (int k = 0; k<accumCost[i][j].length; k++) {
                    System.out.print(accumCost[i][j][k] + " ");
                }
                System.out.println();
            }
        }

        // 최종 도착지점의 최소 비용 반환
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            // 방향마다의 최소 비용 중 최소값을 찾는다.
            min = accumCost[N-1][N-1][i] != 0 ? Math.min(min, accumCost[N-1][N-1][i]) : min;
        }

        return min;
    }
}
