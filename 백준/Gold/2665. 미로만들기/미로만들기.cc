#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main() {
   int n;
   cin >> n;
   vector<vector<int>> map(n, vector<int>(n, 0));
   for (int i = 0; i < n; i++) {
      string str;
      cin >> str;
      for (int j = 0; j < n; j++) {
         map[i][j] = str[j] - '0';
      }
   }
   priority_queue<tuple<int, int, int>> pq;
   vector<vector<bool>> visit(n, vector<bool>(n, false));
   pq.push(make_tuple(0, 0, 0));
   visit[0][0] = true;
   int dxdy[4][2] = { {-1,0},{0,-1},{1,0},{0,1} };
   while (!pq.empty()) {
      auto [cnt, x, y] = pq.top();
      cnt *= -1;
      pq.pop();
      if (x == n - 1 && y == n - 1) {
         printf("%d\n", cnt);
         break;
      }
      for (int i = 0; i < 4; i++) {
         int mx = x + dxdy[i][0];
         int my = y + dxdy[i][1];
         if (mx<0 || mx>n - 1 || my<0 || my>n - 1 || visit[mx][my])continue;
         if (map[mx][my] == 1) {
            pq.push(make_tuple(-cnt, mx, my));
         }
         else {
            pq.push(make_tuple(-(cnt + 1), mx, my));
         }
         visit[mx][my] = true;
      }
   }
   return 0;
}