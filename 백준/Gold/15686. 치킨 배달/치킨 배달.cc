#include <bits/stdc++.h>
using namespace std;

// 시간초과가 발생한 이유 : 중복된 케이스가 존재해서
// stores 배열 앞에서부터 순서대로 문을 닫으면서 체크하기 때문에 매개변수로 문 닫은 가게의 index를 넘겨주면 중복을 피할 수 있다.

int pos[51][51];
int n, m;
int minDist = 1e9+10;
vector<pair<int, int>> homes;
vector<pair<int, int>> stores;
bool isClosed[14];

inline int GetDistance(const pair<int, int>& lhs, const pair<int, int>& rhs) {
    return abs(lhs.first - rhs.first) + abs(lhs.second - rhs.second);
}

void closeStores(int cm, int idx) {
    if (cm == m) {
        int totalDist = 0;
        for (auto home : homes) {
            int dist = 1e9+10;
            for (int i = 0; i < stores.size(); i++) {
                if (isClosed[i]) continue;
                dist = min(dist, GetDistance(stores[i], home));
            }
            totalDist += dist;
        }
        minDist = min(minDist, totalDist);
        return;
    }
    if (idx >= stores.size()) return;
    
    isClosed[idx] = 1;
    closeStores(cm - 1, idx + 1);
    isClosed[idx] = 0;
    closeStores(cm, idx + 1);
}

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> pos[i][j];
            if (pos[i][j] == 1) homes.push_back({i, j});
            else if (pos[i][j] == 2) stores.push_back({i, j});
        }
    }
    closeStores(stores.size(), 0);
    cout << minDist;
}