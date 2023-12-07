class Solution {
    
    public long solution(int r1, int r2) {
        long r1Square = (long) Math.pow(r1, 2);
        long r2Square = (long) Math.pow(r2, 2);
        
        long answer = 0;
        long side = 0;
        
        for (long i = 0; i <= r2; i++) {
            long y2 = calculateYCoordinate(r2Square, i);
            long y1 = calculateYCoordinate(r1Square, i);
            
            if (isBorderPoint(r1Square, i)) {
                side++;
            }
            answer += (y2 - y1) * 4;
        }
        
        return answer + side * 4 - 4;
    }

    private long calculateYCoordinate(long rSquare, long x) {
        return (long) Math.sqrt(rSquare - (long) Math.pow(x, 2));
    }

    private boolean isBorderPoint(long rSquare, long x) {
        return Math.sqrt(rSquare - Math.pow(x, 2)) % 1 == 0;
    }
    
}