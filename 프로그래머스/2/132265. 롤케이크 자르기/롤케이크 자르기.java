import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        
        int answer = 0;

        Map<Integer, Integer> dict1 = new HashMap<>();
        Map<Integer, Integer> dict2 = new HashMap<>();

        for (int idx : topping) {
            dict2.put(idx, dict2.getOrDefault(idx, 0) + 1);
        }
        
        for (int idx : topping) {
            dict1.put(idx, dict1.getOrDefault(idx, 0) + 1);

            if (dict2.get(idx) - 1 == 0) {
                dict2.remove(idx);
            } else {
                dict2.put(idx, dict2.get(idx) - 1);
            }
            if (dict1.size() == dict2.size()) {
                answer++;
            }
        }

        return answer;
    }
}