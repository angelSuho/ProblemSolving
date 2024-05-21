import java.io.*;
import java.util.*;

public class Main {

    public static class Computer implements Comparable<Computer> {
        int cptNum, time;

        Computer(int cptNum, int time) {
            this.cptNum = cptNum;
            this.time = time;
        }

        @Override
        public int compareTo(Computer other) {
            return Integer.compare(this.time, other.time);
        }
    }

    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 컴퓨터 간 연결 정보를 저장할 그래프
            List<List<Computer>> graph = new ArrayList<>();

            // 컴퓨터 번호 및 감염 시간
            initComputerStatus(graph, n, d);

            // 감염 시간 계산
            calculateInfectTime(c, graph, n, sb);
        }
        String result = sb.toString();
        System.out.print(result);
    }

    private static void initComputerStatus(List<List<Computer>> graph, int n, int d) throws IOException {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // a번 컴퓨터와 b번 컴퓨터가 연결되어 있고, 데이터 전송 시간은 s
            graph.get(b).add(new Computer(a, s));
        }
    }

    private static void calculateInfectTime(int c, List<List<Computer>> graph, int n, StringBuilder sb) {
        int[] distance = new int[n + 1];

        // 최소 값 저장을 위한 MAX_VALUE로 초기화
        Arrays.fill(distance, MAX_VALUE);
        distance[c] = 0;

        // 최단 경로 계산을 위한 우선순위 큐
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        // 감염된 컴퓨터 c부터 시작
        pq.add(new Computer(c, 0));

        while (!pq.isEmpty()) {
            Computer currentCom = pq.poll();
            if (currentCom.time > distance[currentCom.cptNum]) continue;

            for (Computer next : graph.get(currentCom.cptNum)) {
                // 다음 컴퓨터로 이동하는 시간이 더 짧은 경우
                // (기존 최단 경로 시간 > 현재 경위치 최단 시간 + 다음 컴퓨터로 이동하는 시간)
                if (distance[next.cptNum] > distance[currentCom.cptNum] + next.time) {
                    distance[next.cptNum] = distance[currentCom.cptNum] + next.time;
                    pq.add(new Computer(next.cptNum, distance[next.cptNum]));
                }
            }
        }

        int count = 0;
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] != MAX_VALUE) {
                count++;
                if (distance[i] > maxTime) {
                    maxTime = distance[i];
                }
            }
        }

        sb.append(count).append(" ").append(maxTime).append("\n");
    }
}
