import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int index;     // 문서의 원래 위치
        int priority;  // 문서의 우선순위

        Node(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Node(i, priority));
                pq.add(priority);
            }

            int answer = 0;

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                // 현재 문서의 중요도가 가장 높다면 인쇄
                if (current.priority == pq.peek()) {
                    pq.poll(); // 우선순위 큐에서 제거
                    answer++;
                    if (current.index == target) {
                        System.out.println(answer);
                        break;
                    }
                } else {
                    queue.add(current); // 다시 뒤로 보내기
                }
            }
        }
    }
}
