import java.util.*;

class Solution {
    public int solution(int[] citations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < citations.length; i++) {
            queue.add(citations[i]);
        }

        int answer = 0;
        while (!queue.isEmpty() && answer < queue.peek()) {
            queue.poll();
            answer++;
        }

        return answer;
    }
}
