class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] sqare = new int[rows][columns];
        int answerIndex = 0;
        int number = 1;

        for(int row = 0 ; row < rows ; row++) {
            for(int column = 0; column < columns ; column++) {
                sqare[row][column] = number;
                number++;
            }
        }

        for(int[] query : queries) {
            int min = number;
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int temp1 = 0;
            int temp2 = 0;
            int direction = 1;
            int xPointer = x1;
            int yPointer = y1;
            temp1 = sqare[xPointer][yPointer];

            while (direction < 5) {
                if (direction == 1) {
                    yPointer++;
                    if(yPointer == y2) direction++;
                }
                else if (direction == 2) {
                    xPointer++;
                    if(xPointer == x2) direction++;
                }
                else if (direction == 3) {
                    yPointer--;
                    if(yPointer == y1) direction++;
                }
                else if (direction == 4) {
                    xPointer--;
                    if(xPointer == x1) direction++;
                }

                temp2 = sqare[xPointer][yPointer];
                sqare[xPointer][yPointer] = temp1;
                temp1 = temp2;

                if(min > temp2) min = temp2;

                if (xPointer == x1 && yPointer == y1) {
                    answer[answerIndex] = min;
                    answerIndex++;
                    break;
                }
            }
        }
        return answer;
    }
}
