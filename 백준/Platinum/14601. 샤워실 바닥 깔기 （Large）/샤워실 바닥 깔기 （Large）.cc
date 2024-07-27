#include <bits/stdc++.h>
using namespace std;

int area[130][130];
int counter = 0;
bool check = true;

void partition(int x, int y, int n, int hx, int hy) {
    counter++;
    int half = (1 << (n - 1));
    // {1, 2, 3, 4}사분면 순서
    vector<pair<int, int>> holes = { {x + half, y + half}, {x + half - 1, y + half}, {x + half - 1, y + half - 1}, {x + half, y + half - 1} };
    vector<pair<int, int>> origins = { {x + half, y + half}, {x, y + half}, {x, y}, {x + half, y} };
    // 구멍이 위치한 곳 찾기
    int pos = -1;
    for (int i = 0; i < 4; i++) {
        if (hx >= origins[i].first && hx < origins[i].first + half &&
            hy >= origins[i].second && hy < origins[i].second + half) {
            pos = i;
            break;
        }
    }
    if (pos == -1) {
        check = false;
        return;
    }
    for (int i = 0; i < 4; i++) {
        if (pos != i) area[holes[i].second][holes[i].first] = counter;
    }
    if (n == 1) return;

    holes[pos] = {hx, hy};
    for (int i = 0; i < 4; i++) partition(origins[i].first, origins[i].second, n - 1, holes[i].first, holes[i].second);
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int k, ix, iy;
    cin >> k >> ix >> iy;
    partition(1, 1, k, ix, iy);
    area[iy][ix] = -1;
    if (!check) {
        cout << -1;
        return 0;
    }
    int length = (1 << k);
    for (int i = length; i >= 1; i--) {
        for (int j = 1; j <= length; j++) {
            cout << area[i][j] << " ";
        }
        cout << '\n';
    }
}