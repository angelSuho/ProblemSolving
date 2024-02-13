import java.io.*;
import java.util.*;

public class Main {
    
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());
            parents = new int[n + 1];
            Arrays.fill(parents, 0);

            for (int i = 1; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                // 부모 노드, 자식 노드
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                // 자식노드 위치에 부모노드 저장
                parents[child] = parent;
            }

            // 공통 조상 찾을 두 노드
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            int result = findCommonParent(node1, node2);
            System.out.println(result);
        }
    }

    public static int findCommonParent(int node1, int node2) {
        // 첫 번째 노드에서 루트까지의 경로 저장
        Set<Integer> path = new HashSet<>();
        while (node1 != 0) {
            path.add(node1);
            // node1의 부모 노드로 이동
            node1 = parents[node1];
        }

        // 두 번째 노드에서 루트까지 이동하면서 첫 번째 노드의 경로와 일치하는지 확인
        while (node2 != 0) {
            if (path.contains(node2)) {
                return node2;
            }
            // node2의 부모 노드로 이동
            node2 = parents[node2];
        }

        throw new RuntimeException("No common parent");
    }
}