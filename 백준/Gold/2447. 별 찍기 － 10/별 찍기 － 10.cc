#include <iostream>
#include <cmath>
using namespace std;

void starView(string* &lines, int n, int x, int y) { // x,y는 오프셋, n은 한 변의 길이
    if (n == 1) {
        lines[y][x] = '*';
        return;
    }
    starView(lines, n / 3, x, y);
    starView(lines, n / 3, x + n / 3, y);
    starView(lines, n / 3, x + 2 * n / 3, y);
    starView(lines, n / 3, x, y + n / 3);
    for (int j = y + n / 3; j < y + 2 * n / 3; j++) {
        for (int i = x + n / 3; i < x + 2 * n / 3; i++) {
            lines[j][i] = ' ';
        }
    }
    starView(lines, n / 3, x + 2 * n / 3, y + n / 3);
    starView(lines, n / 3, x, y + n * 2 / 3);
    starView(lines, n / 3, x + n / 3, y + n * 2 / 3);
    starView(lines, n / 3, x + 2 * n / 3, y + n * 2 / 3);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    string* lines = new string[n];
    for (int i = 0; i < n; i++) {
        lines[i] = string(n, ' ');
    }
    starView(lines, n, 0, 0);
    for (int i = 0; i < n; i++) {
        cout << lines[i] << '\n';
    }
}