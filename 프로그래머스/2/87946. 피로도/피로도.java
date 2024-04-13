import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return explore(k, dungeons, visited, 0);
    }

    private int explore(int k, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count;
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 탐험 가능한 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                maxCount = Math.max(maxCount, explore(k - dungeons[i][1], dungeons, visited, count + 1));
                visited[i] = false;
            }
        }
        return maxCount;
    }
}
