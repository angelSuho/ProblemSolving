#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int map[100][100];
int dxdy[4][2] ={{-1,0},{0,-1},{1,0},{0,1}};
int n,m;
vector<pair<int,int>> cheese;

bool melt(int x, int y){
    int cnt = 0;
    for(int i=0;i<4;i++){
        int mx = x+dxdy[i][0];
        int my = y+dxdy[i][1];
        if(mx<0||mx>n-1||my<0||my>m-1) continue;
        if(map[mx][my]==2) cnt++;
    }
    return cnt >= 2 ? true : false;
}

void check(){
    for(auto it = cheese.begin();it!=cheese.end();){
        if(melt(it->first,it->second)){
            map[it->first][it->second]=0;
            it = cheese.erase(it);
        }
        else
            it++;
    }
}

void aircheck(){
    bool visit[100][100]={false,};
    queue<pair<int,int>> q;
    q.push(make_pair(0,0));
    map[0][0]=2;
    visit[0][0]=true;
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        for(int i=0;i<4;i++){
            int mx = x+dxdy[i][0];
            int my = y+dxdy[i][1];
            if(mx<0||mx>n-1||my<0||my>m-1||visit[mx][my])continue;
            if(map[mx][my]==1)continue;
            map[mx][my]=2;
            q.push(make_pair(mx,my));
            visit[mx][my]=true;
        }
    }
}

int main()
{
    cin>>n>>m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>map[i][j];
            if(map[i][j])
                cheese.push_back(make_pair(i,j));
        }
    }

    int time = 0;
    while(cheese.size()>0){
        aircheck();
        check();
        time++;
    }
    printf("%d\n",time);
    return 0;
}