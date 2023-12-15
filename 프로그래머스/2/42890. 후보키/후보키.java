import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

class Solution {

    public static int minimalityCheck() {

        Vector<Integer> ansString = new Vector<Integer>();
        while (!pq.isEmpty()) {
            String str = pq.poll();
            int state = 0;
            for (int i = 0; i < str.length(); i++) {
                state |= 1 << Integer.parseInt(str.charAt(i) + "");
            }

            if (ansString.isEmpty()) {
                ansString.add(state);
                continue;
            }

            boolean check = false;
            for (int i = 0; i < ansString.size(); i++) {
                if ((ansString.get(i) | state) == state) {
                    check = true;
                    break;
                }
            }

            if (!check)
                ansString.add(state);

        }
        return ansString.size();
    }

    public static void Recursion(String[][] relation, int index) {

        if (index > C || stack.size() > C)
            return;

        if (!stack.isEmpty()) {

            Vector<String> vector = new Vector<String>();
            for (int r = 0; r < R; r++) {
                StringBuffer sb = new StringBuffer();
                for (int c = 0; c < stack.size(); c++) {
                    int pos = stack.get(c);
                    sb.append(relation[r][pos]);
                }

                if (!vector.contains(sb.toString()))
                    vector.add(sb.toString());
                else
                    break;
            }

            if (vector.size() == R) {
                StringBuffer sb = new StringBuffer();
                for (int c = 0; c < stack.size(); c++) {
                    sb.append(stack.get(c).toString());
                }
                pq.offer(sb.toString());
                return;
            }
        }

        stack.push(index);
        Recursion(relation, index + 1);
        stack.pop();
        Recursion(relation, index + 1);
    }

    static int ANS;
    static int R, C;
    static PriorityQueue<String> pq;
    static Stack<Integer> stack;

    public int solution(String[][] relation) {
        int answer = 0;
        ANS = 0;
        R = relation.length;
        C = relation[0].length;

        stack = new Stack<Integer>();
        pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // TODO Auto-generated method stub
                return s2.length() > s1.length() ? -1 : 1;
            }
        });

        Recursion(relation, 0);

        answer = minimalityCheck();
        return answer;
    }
}