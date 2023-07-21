import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Village implements Comparable<Village> {
        long x, a;
        
        public Village(long x, long a) {
            this.x = x;
            this.a = a;
        }
        
        @Override
        public int compareTo(Village o) {
            return Long.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Village[] villages = new Village[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            villages[i] = new Village(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        
        Arrays.sort(villages);
        
        long totalPopulation = 0;
        for (Village v : villages) {
            totalPopulation += v.a;
        }
        
        long halfPopulation = 0;
        for (Village v : villages) {
            halfPopulation += v.a;
            if (halfPopulation >= (totalPopulation + 1) / 2) {
                System.out.println(v.x);
                break;
            }
        }
    }
}
