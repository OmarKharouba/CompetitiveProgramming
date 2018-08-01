#include <bits/stdc++.h>
using namespace std;

#define ll long long

struct num
{
    int val, cnt2, cnt3;

    bool operator<(num p)
    {
        if (cnt2 != p.cnt2)
            return cnt2 > p.cnt2;
        return cnt3 < p.cnt3;
    }
};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, a, b;
    cin >> n;
    n += 2;
    set<int> s;
    num arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i].val;
        arr[i].cnt2 = 0;
        arr[i].cnt3 = 0;
        if (i == 0)
            a = arr[i].val;
        if (i == 1)
            b = arr[i].val;
        int tmp = arr[i].val;
        while (tmp % 2 == 0)
        {
            tmp /= 2;
            arr[i].cnt2++;
        }
        while (tmp % 3 == 0)
        {
            tmp /= 3;
            arr[i].cnt3++;
        }
        s.insert(tmp);
    }
    sort(arr, arr + n);
    bool ok = true;
    for (int i = 0; i + 1 < n; i++)
        if (arr[i].cnt2 < arr[i + 1].cnt2 || arr[i].cnt3 > arr[i + 1].cnt3)
            ok = false;

    if (!ok || s.size() != 1 || arr[0].val != a || arr[n - 1].val != b)
        cout << -1 << endl;
    else
    {
        cout << arr[0].val << " ";
        for (int i = 1; i < n; i++)
        {
            ll cur = arr[i - 1].val;
            while (arr[i].cnt3 > arr[i - 1].cnt3)
            {
                cur *= 3;
                arr[i - 1].cnt3++;
                cout << cur << " ";
            }
            while (arr[i - 1].cnt2 > arr[i].cnt2)
            {
                cur /= 2;
                arr[i - 1].cnt2--;
                cout << cur << " ";
            }
        }
    }
}