import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        String answer = "";

        for (String name: participant) {
            map.putIfAbsent(name, 0);
            map.put(name, map.get(name) + 1);

        }

        for (String name: completion) {
            if (map.get(name) == 0) {
                continue;
            }
            map.put(name, map.get(name) - 1);
        }

        for (String name: participant) {
            if (map.get(name) == 0) {
                continue;
            }
            answer = name;
            break;
        }

        return answer;
    }
}