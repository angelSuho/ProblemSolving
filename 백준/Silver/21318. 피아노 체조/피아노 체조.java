import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); 
        int[] music = new int[n];
        int[] mistakes = new int[n];

        // 악보별 난이도 입력
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            music[i] = Integer.parseInt(st.nextToken());
        }

        // 실수 여부 계산 (난이도가 감소하는 지점 체크)
        for (int i = 1; i < n; i++) {
            //
            if (music[i - 1] > music[i]) {
                mistakes[i] = 1;
            }
        }

        // 누적합 배열 생성
        int[] accumulatedMistakes = new int[n];
        accumulatedMistakes[0] = mistakes[0];
        for (int i = 1; i < n; i++) {
            accumulatedMistakes[i] = accumulatedMistakes[i - 1] + mistakes[i];
        }

        // 질문 입력, 악보의 x부터 y까지
        int question = Integer.parseInt(bf.readLine());
        for (int idx = 0; idx < question; idx++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // 실수하는 곡의 개수 계산
            int mistake = accumulatedMistakes[y] - accumulatedMistakes[x];
            System.out.println(mistake);
        }
    }
}