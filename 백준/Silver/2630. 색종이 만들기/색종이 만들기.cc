#include <bits/stdc++.h>
using namespace std;
int white = 0;
int blue = 0;

void partition(vector<vector<int>>& colorPaper, int n, pair<int, int> pos) {
    if (n == 1) {
        (colorPaper[pos.second][pos.first] == 1) ? blue++ : white++;
        return;
    }
    bool square = true;
    for (int i = pos.second; i < pos.second + n; i++) {
        for (int j = pos.first; j < pos.first + n; j++) {
            if (colorPaper[i][j] != colorPaper[pos.second][pos.first]) {
                square = false;
                break;
            }
        }
    }
    if (square == true) {
        (colorPaper[pos.second][pos.first] == 1) ? blue++ : white++;
    }
    else {
        partition(colorPaper, n / 2, pos);
        partition(colorPaper, n / 2, make_pair(pos.first + n / 2, pos.second));
        partition(colorPaper, n / 2, make_pair(pos.first, pos.second + n / 2));
        partition(colorPaper, n / 2, make_pair(pos.first + n / 2, pos.second + n / 2));
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    pair<int, int> initPos(0, 0);
    cin >> n;
    vector<vector<int>> colorPaper(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> colorPaper[i][j];
        }
    }
    partition(colorPaper, n, initPos);
    cout << white << '\n' << blue;
}