import java.util.*;

class Solution {

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> box = new HashMap<>();
        for (int idx = 0; idx < tangerine.length; idx++) {
            box.put(tangerine[idx], box.getOrDefault(tangerine[idx], 0) + 1);
        }

        ArrayList<Integer> sizes = new ArrayList<>(box.values());
        sizes.sort(((x1, x2) -> x2 - x1));

        int count = 0;
        for (int idx = 0; idx < sizes.size(); idx++) {
            count += sizes.get(idx);
            answer++;
            if(count >= k){
                return answer;
            }
        }

        return answer;
    }
}