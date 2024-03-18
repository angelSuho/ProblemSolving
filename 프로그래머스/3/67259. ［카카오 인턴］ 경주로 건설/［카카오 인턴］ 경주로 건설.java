import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int N;

    public int solution(int[][] board) {
        N = board.length;
        return buildTrack(board);
    }

    private int buildTrack(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, -1, 0});
        int[][][] costs = new int[N][N][4];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dir = cur[2], cost = cur[3];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {
                    int newCost = cost;
                    if (dir == -1 || dir == i) {
                        // 직선 방향으로 이동하는 경우
                        newCost += 100;
                    } else {
                        // 코너를 도는 경우
                        // 코너 비용 + 직선 비용
                        newCost += 600;
                    }

                    // bfs로 갱신된 최소 비용 저장
                    if (costs[nx][ny][i] == 0 || costs[nx][ny][i] > newCost) {
                        costs[nx][ny][i] = newCost;
                        queue.offer(new int[]{nx, ny, i, newCost});
                    }
                }
            }
        }

        // 최종 도착지점의 최소 비용 반환
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) { // 상하좌우
            // 방향마다의 최소 비용 중 최소값을 찾는다.
            minCost = costs[N-1][N-1][i] != 0 ? Math.min(minCost, costs[N-1][N-1][i]) : minCost;
        }

        return minCost;
    }
}
