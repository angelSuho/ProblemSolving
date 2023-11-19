class Solution {
    public int[] solution(int n, long left, long right) {
        long size = (long) Math.pow(n, 2);
        int len = (int)(right - left + 1);
        int answer[] = new int[len];
        int idx = 0;
        for(long i = left; i <= right; i++) {
            int row = (int)(i / n) + 1;
            int col = (int)(i % n) + 1;
            if(row >= col) answer[idx] = row;
            else answer[idx] = col;
            idx++;
        }
        return answer;
    }
}