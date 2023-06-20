import java.util.*;
class Solution {
    public long maxMinusMin(long[] sum) {
        long max = -Long.MAX_VALUE; long min = Long.MAX_VALUE;
        for(int idx = 0; idx < sum.length; idx++) {
            if(max < sum[idx]){
                max = sum[idx];
            }  if(min > sum[idx]){
                min = sum[idx];
            }
        } return Math.abs(max - min);
    }
    
    public long solution(int[] sequence) {
        long answer = 0;
        long[] sum = new long[sequence.length + 1];
        for(int idx = 1; idx < sum.length; idx++)
        {
            if(idx % 2 == 0) {
                sum[idx] = sum[idx - 1] + (long) sequence[idx - 1] * -1;
            } else {
                sum[idx] = sum[idx - 1] + (long) sequence[idx - 1];
            }
        }
        return  maxMinusMin(sum);
    }
}