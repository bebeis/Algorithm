#include <bits/stdc++.h>
using namespace std;

// n, m <= 1000
// time limit : 1초 --> 아마 O(nm)으로 끝내야 함

int a[1005][1005];
int d[1005][1005];

int main(void) {
    int n, m, max = 0;
    scanf("%d %d", &n, &m);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) scanf("%1d", &a[i][j]);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (a[i][j]) d[i][j] = min({d[i - 1][j - 1], d[i][j - 1], d[i - 1][j]}) + 1;
            if (max < d[i][j]) max = d[i][j];
        }
    }
    printf("%d", max * max);
}