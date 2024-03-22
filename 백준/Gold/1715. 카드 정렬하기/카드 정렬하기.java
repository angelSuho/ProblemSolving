import java.util.*;
import java.io.*;

public class Main {
    
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        Queue<Integer> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }
        
        int totalCompare = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            int tmp = first + second;
            totalCompare += tmp;
            pq.add(tmp);
        }
        
        System.out.println(totalCompare);
    }
    
}