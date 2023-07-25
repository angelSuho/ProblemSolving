import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(scanner.nextInt());
        }
        int request = 2100000000;
        int mIdx = 0;
        for (int i = 0; i < k; i++) {
            if (request >= v.get(i)) {
                request = v.get(i); 
                mIdx = i + 1;
            }
        }
        int ans = request;
        while (mIdx + k <= n) {
            int re = 2100000000;
            int idx = 0;
            for (int i = mIdx; i < mIdx + k; i++) {
                if (re >= v.get(i)) {
                    re = v.get(i);
                    idx = i + 1;
                }
            }
            mIdx = idx;
            if (ans < re) {
                ans = re;
            }
        }
        System.out.println(ans);
    }
}