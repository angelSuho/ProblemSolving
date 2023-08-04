import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input = bf.readLine();

        int aCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aCount++;
            }
        }

        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (input.charAt(i) == 'b') {
                bCount++;
            }
        }

        int minCount = bCount;
        for (int i = aCount; i < input.length() + aCount; i++) {
            if (input.charAt(i % input.length()) == 'b') {
                bCount++;
            }
            if (input.charAt(i - aCount) == 'b') {
                bCount--;
            }
            minCount = Math.min(minCount, bCount);
        }

        System.out.println(minCount);
    }
}
