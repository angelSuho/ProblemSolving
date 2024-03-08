class Solution {
    public static int solution(int n) {
        int countOfOne = Integer.bitCount(n);
        int nextNumber = n + 1;

        while (true) {
            if (Integer.bitCount(nextNumber) == countOfOne)
                break;
            nextNumber++;
        }

        return nextNumber;
    }
}