class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int sum = 0;
        int[] result = new int[2];
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];

            while (sum > k) {
                sum -= sequence[start++];
            }

            if (sum == k && (end - start + 1) < minLength) {
                minLength = end - start + 1;
                result[0] = start;
                result[1] = end;
            }
        }
        return result;
    }
}