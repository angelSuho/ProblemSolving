import java.util.*;

class Solution {
    
    // n: 송전탑의 개수, wires: 전선 정보
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> tree = new ArrayList<>();
            
            for (int j = 0; j <= n; j++) {
                tree.add(new ArrayList<>());
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) { // 전선 분리
                    continue;
                }
                tree.get(wires[j][0]).add(wires[j][1]);
                tree.get(wires[j][1]).add(wires[j][0]);
            }
            
            boolean[] visited = new boolean[n + 1];
            
            // wires[i][0]: 끊어진 전선의 시작점
            int cnt = countTreeNodes(tree, visited, wires[i][0]);
            
            // 최소 차이 비교
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        
        return answer;
    }

    // 트리 노드 수 계산
    private static int countTreeNodes(List<List<Integer>> tree, boolean[] visited, int cutWire) {
        visited[cutWire] = true;
        int cnt = 1;
        
        for (int nCutWire : tree.get(cutWire)) {
            if (!visited[nCutWire]) {
                cnt += countTreeNodes(tree, visited, nCutWire);
            }
        }
        return cnt;
    }
}