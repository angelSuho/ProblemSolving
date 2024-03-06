import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = enemy.length;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            
            for (int i = 0; i < enemy.length; i++) {
                n -= enemy[i];
                maxHeap.add(enemy[i]);
                
                if (n < 0) {
                    if (k > 0) {
                        try {
                        n += maxHeap.poll();
                        k --;
                        } catch (NullPointerException e) {
                            answer = i; break;
                        }
                    } else {
                        answer = i; break;
                    }
                }
            }
            return answer;
        }
    }