import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static StringTokenizer st;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(bf.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[] trains = new int[N];

        for (int i = 0; i < M; i++) {
            commandMilkyWay(trains);
        }
        
        System.out.println(countTrains(trains));
    }

    private static void commandMilkyWay(int[] trains) throws IOException {
        st = new StringTokenizer(bf.readLine());
        int command = parseInt(st.nextToken());
        int trainNumber = parseInt(st.nextToken()) - 1;

        switch (command) {
            case 1 -> {
                int seat1 = parseInt(st.nextToken()) - 1;
                trains[trainNumber] |= (1 << seat1);
            }
            case 2 -> {
                int seat2 = parseInt(st.nextToken()) - 1;
                trains[trainNumber] &= ~(1 << seat2);
            }
            case 3 -> {
                if ((trains[trainNumber] & (1 << 19)) != 0) {
                    trains[trainNumber] &= ~(1 << 19);
                }
                trains[trainNumber] <<= 1;
            }
            case 4 -> {
                if ((trains[trainNumber] & 1) != 0) {
                    trains[trainNumber] &= ~1;
                }
                trains[trainNumber] >>= 1;
            }
        }
    }

    private static int countTrains(int[] trains) {
        Set<Integer> passedTrains = new HashSet<>();
        int count = 0;
        for (int train : trains) {
            if (!passedTrains.contains(train)) {
                passedTrains.add(train);
                count++;
            }
        }
        return count;
    }
}