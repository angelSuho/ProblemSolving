import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushis = new int[n+k-1];
        for (int i = 0; i < n; i++) {
            sushis[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k-1; i++) {
            sushis[n+i] = sushis[i];
        }

        int result = calculatedSushiCount(sushis, n, d, k, c);
        System.out.println(result);
    }

    public static int calculatedSushiCount(int[] sushis, int n, int d, int k, int c) {
        int[] sushiTypes = new int[d + 1];
        int typeCnt = 0;
        int maxTypeCnt = 0;

        for (int i = 0; i < k; i++) {
            if (sushiTypes[sushis[i]] == 0) typeCnt++;
            sushiTypes[sushis[i]]++;
        }
        sushiTypes[c]++;
        
        if (sushiTypes[c] == 1) typeCnt++;
        maxTypeCnt = typeCnt;

        for (int i = 1; i < n; i++) {
            if (--sushiTypes[sushis[i-1]] == 0) typeCnt--;
            if (sushiTypes[sushis[(i+k-1) % n]]++ == 0) typeCnt++;
            maxTypeCnt = Math.max(maxTypeCnt, typeCnt);
        }

        return maxTypeCnt;
    }
}