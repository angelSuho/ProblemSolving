import java.util.Arrays;

class Solution {
     public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 배열 A를 오름차순으로 정렬
        Arrays.sort(A);
        // 배열 B를 내림차순으로 정렬
        Arrays.sort(B);
        
        int length = A.length;
        for(int i = 0; i < length; i++) {
            // 배열 A의 i번째 원소와 배열 B의 마지막에서 i번째 원소를 곱하여 누적
            answer += A[i] * B[length - i - 1];
        }
        
        return answer;
    }
}
