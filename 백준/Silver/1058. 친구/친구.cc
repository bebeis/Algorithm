#include <bits/stdc++.h>
using namespace std;

char frd[52][52];
int d[52];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, max_friends = -1;
    char c;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> frd[i][j];
            if (frd[i][j] == 'Y') d[i]++;
        }
    }

    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == k || j == k) continue;
                if (frd[i][k] == 'Y' && frd[j][k] == 'Y' && frd[i][j] != 'Y') {
                    if (frd[i][j] != '2') {
                        frd[i][j] = frd[j][i] = '2';
                        d[i]++;
                        d[j]++;
                    }
                }
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (max_friends < d[i]) max_friends = d[i];
    }
    cout << max_friends;
}
