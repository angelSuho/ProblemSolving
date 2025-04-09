import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static String[][][] arr;
    private static final List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new String[N][M][2];

        for (int i = 0; i < N; i++) {
            String[] tmp = bf.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j][0] = tmp[j];
                arr[i][j][1] = "-1";
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Objects.equals(arr[i][j][0], "*")) {
                    validateCross(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Objects.equals(arr[i][j][0], "*") && Objects.equals(arr[i][j][1], "-1")) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void validateCross(int x, int y) {
        int crossSize = 1;
        boolean isCross = true;

        while (isCross) {
            if (x - crossSize >= 0 && x + crossSize < arr.length && y - crossSize >= 0 && y + crossSize < arr[0].length) {
                if (Objects.equals(arr[x - crossSize][y][0], "*") && Objects.equals(arr[x + crossSize][y][0], "*") &&
                        Objects.equals(arr[x][y - crossSize][0], "*") && Objects.equals(arr[x][y + crossSize][0], "*")) {
                    result.add((x+1) + " " + (y+1) + " " + crossSize);
                    arr[x][y][1] = String.valueOf(crossSize);
                    arr[x - crossSize][y][1] = String.valueOf(crossSize);
                    arr[x + crossSize][y][1] = String.valueOf(crossSize);
                    arr[x][y - crossSize][1] = String.valueOf(crossSize);
                    arr[x][y + crossSize][1] = String.valueOf(crossSize);
                    crossSize++;
                } else {
                    isCross = false;
                }
            } else {
                isCross = false;
            }
        }
    }
}
