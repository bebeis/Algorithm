#include <bits/stdc++.h>
using namespace std;

// a > b에서 자꾸 통과가 안되서 원을 직선으로 바꿔서 해결
struct Line {
    long long rx;
    long long tx;
    int origin;
};

int n, m;
vector<Line> lines;
bool incl_lines[500001];

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int rx, tx;
        cin >> rx >> tx;
        // idea. 직선으로 변형해준다
        if (rx > tx) lines.push_back({rx, tx + n, i});
        else {
            lines.push_back({rx, tx, i});
            lines.push_back({rx + n, tx + n, i});
        }
    }
    sort(lines.begin(), lines.end(), [](const Line& a, const Line& b) {
        if (a.rx == b.rx) return a.tx > b.tx;
        return a.rx < b.rx;
    });
    int brx = 0, btx = 0;
    for (auto [rx, tx, origin] : lines) {
        if (incl_lines[origin]) continue;
        if (brx <= rx && tx <= btx) {
            incl_lines[origin] = true;
            continue;
        }
        brx = rx; btx = tx;
    }
    for (int i = 0; i < m; i++) {
        if (!incl_lines[i]) cout << i + 1 << " ";
    }
}