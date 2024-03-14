class Solution {
    public int solution(int n) {
        int count = 0;

        for (int start = 1; start <= n; start++) {
            int sum = 0;
            for (int end = start; sum < n; end++) {
                sum += end;
                if (sum == n) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}