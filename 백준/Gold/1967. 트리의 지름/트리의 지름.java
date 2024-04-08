import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static class Node {
        int id;
        int weight;

        Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bf.readLine());

        List<List<Node>> nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.get(parent).add(new Node(child, weight));
            nodes.get(child).add(new Node(parent, weight));
        }

        // root에서 가장 먼 노드 탐색
        Node distantNode = bfs(1, nodes);
        // 가장 먼 노드에서 가장 먼 노드 탐색
        Node distantNodeToDistantNode = bfs(distantNode.id, nodes);

        System.out.println(distantNodeToDistantNode.weight);
    }

    private static Node bfs(int start, List<List<Node>> graph) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(new Node(start, 0));
        visited[start] = true;

        Node maxWeight = new Node(start, 0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // 가장 먼 노드 거리 갱신
            if (currentNode.weight > maxWeight.weight) {
                maxWeight = currentNode;
            }

            // 연결지점 중 방문하지 않은 곳
            for (Node next : graph.get(currentNode.id)) {
                if (!visited[next.id]) {
                    visited[next.id] = true;
                    queue.add(new Node(next.id, currentNode.weight + next.weight));
                }
            }
        }

        return maxWeight;
    }
}
