import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (maxHeap.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(maxHeap.poll());
                }
            } else {
                for (int j = 0; j < a; j++) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}