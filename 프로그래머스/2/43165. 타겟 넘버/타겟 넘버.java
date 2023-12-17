class Solution {
    public int solution(int[] numbers, int target) {
        int answer = backTrack(numbers, target, 0);
        return answer;
    }

    public int backTrack(int[] numbers, int target, int idx) {
        if (idx == numbers.length) {
            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }

            return sum == target ? 1 : 0;
        }

        int res = 0;
        res += backTrack(numbers, target, idx + 1);

        numbers[idx] *= -1;
        res += backTrack(numbers, target, idx + 1);

        numbers[idx] *= -1;

        return res;
    }
}