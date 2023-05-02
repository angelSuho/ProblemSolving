package org.example;

import java.util.*;

class 과제_진행하기 {

    static class Node{
        int index;
        int start;
        int playTime;

        public Node(int index, int start, int playTime){
            this.index = index;
            this.start = start;
            this.playTime = playTime;
        }
    }

    public List<String> solution(String[][] plans) {

        List<String> answer = new ArrayList<>();
        Node[] myPlans = new Node[plans.length];

        for(int i = 0 ; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            myPlans[i] = new Node(i, Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]), Integer.parseInt(plans[i][2]));
        }

        Arrays.sort(myPlans, Comparator.comparingInt(o -> o.start));
        Stack<Node> remain = new Stack<>();

        for(int i = 0 ; i < myPlans.length - 1; i++){

            int cur = myPlans[i].start + myPlans[i].playTime;
            int next = myPlans[i+1].start;

            if(cur <= next){
                answer.add(plans[myPlans[i].index][0]);

                int qwe = next - cur;
                while(qwe > 0 && !remain.isEmpty()){
                    int del = remain.peek().playTime - qwe;
                    remain.peek().playTime = Math.max(0, del);
                    if(del <= 0) {
                        qwe = -1 * del;
                        answer.add(plans[remain.pop().index][0]);
                    } else{
                        qwe = 0;
                    }
                }
            } else{
                myPlans[i].playTime = (cur - next);
                remain.push(myPlans[i]);
            }
        }
        answer.add(plans[myPlans[myPlans.length - 1].index][0]);

        while(!remain.isEmpty()){
            answer.add(plans[remain.pop().index][0]);
        }

        return answer;
    }
}