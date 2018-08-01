#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, x;
    cin >> n >> x;
    int c = 0;
    int z = 0;
    bool ok = true;
    while (n > 0)
    {
        int y = n % 10 + c;
        n /= 10;
        if (y == 10)
        {
            z++;
            continue;
        }
        if (y > 0)
        {
            y = 10 - y;
            c = 1;
        }
        if (x < y)
        {
            ok = false;
            break;
        }
        z++;
        x -= y;
    }
    if (ok && c == 1)
    {
        while (x >= 9)
        {
            x -= 9;
            z++;
        }
    }

    cout << z << endl;
}