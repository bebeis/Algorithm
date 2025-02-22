#include <bits/stdc++.h>
using namespace std;

int a[1000003];
int b[1000003];
int c[2000003];
int n, m;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];

    int aidx = 0, bidx = 0;
    for (int i = 0; i < n + m; i++) {
        if (aidx == n) c[i] = b[bidx++];
        else if (bidx == m) c[i] = a[aidx++];
        else if (a[aidx] <= b[bidx]) c[i] = a[aidx++];
        else c[i] = b[bidx++];
    }

    for (int i = 0; i < n + m; i++) cout << c[i] << ' ';
}