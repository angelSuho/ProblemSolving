class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if (s < n) {
            return new int[]{-1};
        } else if (s == n) {
            for (int i = 0; i < n; i++) {
                answer[i] = 1;
            }
        } else {
            if (s % n == 0) {
                for (int i = 0; i < n; i++) {
                    answer[i] = s / n;
                }
            } else {
                int quotient = s / n;
                int remainder = s % n;
                for (int i = 0; i < n; i++) {
                    answer[i] = quotient;
                }
                for (int i = n - remainder; i < n; i++) {
                    answer[i] = quotient + 1;
                }
            }
        }       

        return answer;
    }
}