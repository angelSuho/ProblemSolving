import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        final int n = maps.length;
        final int m = maps[0].length;
        
        // 방문 여부를 확인할 배열
        boolean[][] visited = new boolean[n][m];
        
        // 상, 하, 좌, 우 방향 이동을 위한 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 시작 지점과 시작 지점에서의 거리 (1) 추가
        visited[0][0] = true; // 시작 지점 방문 처리
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            // 도착지점에 도달했을 경우
            if (x == n - 1 && y == m - 1) {
                return distance;
            }
            
            // 상, 하, 좌, 우 방향으로의 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위를 벗어나지 않고, 방문하지 않았으며, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true; // 방문 처리
                    queue.offer(new int[]{nx, ny, distance + 1}); // 다음 위치와 거리 추가
                }
            }
        }
        
        // 도착지점에 도달할 수 없는 경우
        return -1;
    }
}