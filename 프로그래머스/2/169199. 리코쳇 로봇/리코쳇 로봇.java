import java.util.*;

class Solution {

    static int[][] cnt;
    static char[][] chBoard;
    static int maxX, maxY, minCnt;

    public int solution(String[] board) {
        int answer = -1;
        maxX = board.length;
        maxY = board[0].length();
        minCnt = 99999;
        char[][] chBoard = new char[maxX][maxY];
        cnt = new int[maxX][maxY];

        node start = null;
        for(int i=0; i<maxX; i++){
            chBoard[i] = board[i].toCharArray();
            for(int j=0; j<maxY; j++){
                if(chBoard[i][j]=='R') {
                    start = new node(i, j, 0);
                    cnt[i][j] = 1; //출발지 표시
                }
            }
        }

        this.chBoard = chBoard;
        bfs(start);

        if(minCnt==99999) return -1;
        return answer=minCnt;
    }

    void bfs(node start){

        Queue<node> q = new LinkedList<>();
        q.add(start);

        int[] nextX = {-1, 1, 0, 0};
        int[] nextY = {0, 0, -1, 1};

        while(!q.isEmpty()){

            node now = q.poll();
            //꺼냈더니 골인이라면
            if(chBoard[now.x][now.y]=='G'){
                minCnt = Math.min(minCnt, now.sum);
                continue;
            }
            //이미 앞에서 방문한 곳이라면 
            if(cnt[now.x][now.y]>0 && now.sum > cnt[now.x][now.y]){
                continue;
            }
            for(int i=0; i<4; i++){

                int nX = now.x;
                int nY = now.y;

                while(true) {  

                    //벽 있는지 판별
                    if(nX==0 && nextX[i]<0) break;
                    if(nX==maxX-1 && nextX[i]>0) break;
                    if(nY==0 && nextY[i]<0) break;
                    if(nY==maxY-1 && nextY[i]>0) break;

                    //장애물 있는지 판별
                    if(chBoard[nX+nextX[i]][nY+nextY[i]]=='D') break;

                    nX += nextX[i];
                    nY += nextY[i];
                }
                //멈춘 곳이 이미 적은 횟수로 방문한 곳이라면
                if(cnt[nX][nY]>0 && now.sum+1 >= cnt[nX][nY] ) continue;
                System.out.println(now.sum+" "+nX+" "+nY);
                cnt[nX][nY] = now.sum+1;
                q.add(new node(nX, nY, now.sum+1));

            }   
        }   
    }
}

class node{
    int x, y, sum;
    node(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
