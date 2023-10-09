class Solution {
    public int solution(int storey) {
        int answer = 0;
        int r;
        while (storey > 0) {
            r = storey %10;
            if(r<5) {
                answer+=r;
            } else if(r>5) {
                answer+=(10-r);
                storey +=10;
            } else {  
                answer+=5;
                int tmp = (storey/10) %10;
                if(tmp >=5)
                    storey+=10;
            }
            storey /= 10;
        }

        return answer;
    }
}