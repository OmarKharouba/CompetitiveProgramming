#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin >> n;
    set<int> s;
    while (n--)
    {
        int x;
        cin >> x;
        while (x % 2 == 0)
            x /= 2;
        while (x % 3 == 0)
            x /= 3;
        s.insert(x);
    }
    cout << (s.size() == 1 ? "Yes" : "No") << endl;
}