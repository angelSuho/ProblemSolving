import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(bf.readLine());
        List<String> sortedArr = settingSortedArr(n);
        List<String> result = new ArrayList<>();

        for (String x : sortedArr) {
            for (String str : result) {
                if (str.equals(x.substring(0, str.length()))) {
                    result.remove(str);
                    break;
                }
            }
            result.add(x);
        }

        System.out.println(result.size());
    }

    private static List<String> settingSortedArr(int n) throws IOException {
        List<String> arr = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr.add(st.nextToken());
        }
        return arr.stream().sorted((a, b) -> a.length() - b.length()).collect(Collectors.toList());
    }
}