#include <bits/stdc++.h>
using namespace std;

// CCW 알고리즘 -> 외적을 사용한다. 오른손 법칙을 떠올리면 될 듯

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int x1, y1, x2, y2, x3, y3;
    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
    pair<int, int> CA = {x3 - x1, y3 - y1};
    pair<int, int> AB = {x2 - x1, y2 - y1};

    int result = CA.first * AB.second - AB.first * CA.second;

    if (result > 0) cout << -1;
    else if (result == 0) cout << 0;
    else cout << 1;
}