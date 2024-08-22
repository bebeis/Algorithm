#include <bits/stdc++.h>
using namespace std;

int d[1001][1001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    string a, b, result = "";
    cin >> a >> b;
    for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            if (a[i - 1] == b[j - 1]) d[i][j] = d[i - 1][j - 1] + 1;
            else d[i][j] = max(d[i - 1][j], d[i][j - 1]);
        }
    }

    int i = a.length();
    int j = b.length();

    while (d[i][j]) {
        if (d[i][j] == d[i - 1][j]) i--;
        else if (d[i][j] == d[i][j - 1]) j--;
        else {
            result += a[i - 1];
            i--; j--;
        }
    }

    cout << d[a.length()][b.length()] << '\n';
    if (result.length() > 0) {
        reverse(result.begin(), result.end());
        cout << result;
    }
}