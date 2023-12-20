class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = {};
        answer = new int[2];
        int iAllNum = brown + red;
        int iHeight = 0;

        for (int iBrownWidth = 1; iBrownWidth < brown; iBrownWidth++) {
            iHeight = iAllNum/iBrownWidth;

            if((iBrownWidth-2)*(iHeight-2) == red) {
                answer[0] = iBrownWidth;
                answer[1] = iHeight;
            }
        }
        return answer;
    }
}