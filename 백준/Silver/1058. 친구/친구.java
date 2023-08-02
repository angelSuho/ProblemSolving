import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(bf.readLine());
        boolean[][] friends = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                friends[i][j] = (line.charAt(j) == 'Y');
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (friends[i][j]) {
                    count++;
                } else {
                    for (int k = 0; k < n; k++) {
                        if (friends[i][k] && friends[k][j]) {
                            count++;
                            break;
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}