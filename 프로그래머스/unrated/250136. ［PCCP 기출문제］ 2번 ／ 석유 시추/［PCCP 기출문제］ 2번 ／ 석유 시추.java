import java.util.*;

class Solution {
    
    private static int n, m;

    private static int searchOil(int x, int y, int[][] land, int[][] visited, int idx) {
        if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y] != 0 || land[x][y] == 0) {
            return 0;
        }

        visited[x][y] = idx;
        int oilSize = 1;

        oilSize += searchOil(x + 1, y, land, visited, idx);
        oilSize += searchOil(x - 1, y, land, visited, idx);
        oilSize += searchOil(x, y + 1, land, visited, idx);
        oilSize += searchOil(x, y - 1, land, visited, idx);

        return oilSize;
    }

    public static int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        int idx = 0;
        int maxOil = Integer.MIN_VALUE;

        int[][] visited = new int[n][m];
        int[] oilSizeArray = new int[n * m];

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (land[row][col] == 1 && visited[row][col] == 0) {
                    int oilSizeByRound = searchOil(row, col, land, visited, ++idx);
                    oilSizeArray[idx - 1] = oilSizeByRound;
                }
            }
        }

        for (int col = 0; col < m; col++) {
            Set<Integer> oilSet = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (visited[row][col] != 0) {
                    oilSet.add(visited[row][col] - 1);
                }
            }

            int oilInCol = oilSet.stream().mapToInt(i -> oilSizeArray[i]).sum();
            maxOil = Math.max(maxOil, oilInCol);
        }

        return maxOil;
    }
}