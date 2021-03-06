#include <bits/stdc++.h>
using namespace std;

const int N = (int)1e6;
int n, m;
bool vis[N];

int nxt(int i)
{
    int move = (2 * m - 2) % (2 * n - 2);
    int ret = i;
    int rem = min(n - 1 - ret, move);
    move -= rem;
    ret += rem;
    rem = min(ret, move);
    move -= rem;
    ret -= rem;
    rem = min(n - 1 - ret, move);
    move -= rem;
    ret += rem;
    return ret;
}

int nxt2(int i)
{
    int move = (2 * m - 2) % (2 * n - 2);
    int ret = i;
    int rem = min(ret, move);
    move -= rem;
    ret -= rem;
    rem = min(n - 1 - ret, move);
    move -= rem;
    ret += rem;
    rem = min(ret, move);
    move -= rem;
    ret -= rem;
    return ret;
}

void go(int i)
{
    vis[i] = true;
    int x = nxt(i);
    if (!vis[x])
        go(x);
    x = nxt2(i);
    if (!vis[x])
        go(x);
}

int main()
{
    cin >> n >> m;
    if (n < m)
        swap(n, m);
    int c = 0;
    for (int i = 0; i < n; i++)
        if (!vis[i])
        {
            c++;
            go(i);
        }
    cout << c << endl;
}