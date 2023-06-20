import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            str[i] = st.nextToken();
        }

        st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());

        int index = -1;
        int max = 0;
        for(int i = 0; i< n; i++) {
            int num = 0;
            String tmp = str[i];

            for(int j = 0; j< m; j++) {
                if(tmp.charAt(j) == '0') { num++; }
            }

            if (num%2 != k % 2) {
                continue;
            }

            int patern = 1;
            for(int idx = 0; idx< n; idx++) {
                if(idx!=i && tmp.equals(str[idx])) {
                    patern++;
                }
            }

            if(num<= k && patern > max) {
                max = patern;
                index = i;
            }
        }
        if(index != -1) {
            System.out.println(max);
        } else {
            System.out.println(0);
        }
    }
}
