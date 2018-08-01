#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, q, x;
    cin >> n >> q >> x;
    while (q--)
    {
        int u, v;
        cin >> u >> v;
        if (u == x)
            x = v;
        else if (v == x)
            x = u;
    }
    cout << x << endl;
}