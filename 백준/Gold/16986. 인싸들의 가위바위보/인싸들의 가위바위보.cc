#pragma warning(disable:4996)
#include <iostream>
#include <vector>

using namespace std;

#define FINAL_ROUND     20

int table[9][9];
int enemy[3][FINAL_ROUND];
int N, K;

int dfs(vector<int> arId, vector<bool>& arHand, vector<int> arWin, vector<int> match, int step)
{
    if (step >= FINAL_ROUND)
        return 0;

    int a, b;
    if (match[0] == 0)  a = arId[0];
    else
    {
        a = enemy[match[0] - 1][arId[match[0]]];
        arId[match[0]]++;
    }
    if (match[1] == 0)  b = arId[0];
    else
    {
        b = enemy[match[1] - 1][arId[match[1]]];
        arId[match[1]]++;
    }
    step++;

    if (table[a][b] == 2 || (a == b && match[0] > match[1]))
    {
        arWin[match[0]]++;
        do
        {
            if (++match[1] > 2)
                match[1] = 0;
        } while (match[0] == match[1]);
    }
    else
    {
        arWin[match[1]]++;
        do
        {
            if (++match[0] > 2)
                match[0] = 0;
        } while (match[0] == match[1]);
    }

    if (arWin[0] >= K)
        return 1;
    else if (arWin[1] >= K || arWin[2] >= K)
        return 0;

    if (match[0] == 0 || match[1] == 0)
    {
        for (int i = 0; i < arHand.size(); i++)
        {
            if (arHand[i])
            {
                arHand[i] = false;
                arId[0] = i;
                if (dfs(arId, arHand, arWin, match, step))
                    return 1;
                arHand[i] = true;
            }
        }
        return 0;
    }

    return dfs(arId, arHand, arWin, match, step);
}

int dfs()
{
    vector<int> arId = { 0, 0, 0 };
    vector<bool> arHand(N, true);
    vector<int> arWin = { 0, 0, 0 };
    vector<int> match = { 0, 1 };

    for (int i = 0; i < arHand.size(); i++)
    {
        arHand[i] = false;
        arId[0] = i;
        if (dfs(arId, arHand, arWin, match, 0))
            return 1;
        arHand[i] = true;
    }
    return 0;
}

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);

    cin >> N >> K;
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> table[i][j];

    for (int i = 0; i < FINAL_ROUND; i++)
    {
        cin >> enemy[0][i]; enemy[0][i]--;
    }
    for (int i = 0; i < FINAL_ROUND; i++)
    {
        cin >> enemy[1][i]; enemy[1][i]--;
    }

    cout << dfs();
    return 0;
}