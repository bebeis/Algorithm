#include <bits/stdc++.h>
using namespace std;

// 목적지 도달 --> BFS로 접근
// 방문한 노드를 삭제하는 방식으로 구현
class status {
public:
    status(short x, short y, short beer_count) : x(x), y(y), beer_count(beer_count) {}
    short x;
    short y;
    short beer_count;
};

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        set<pair<short, short>> cov;
        queue<status> Q;
        short n, x, y;
        cin >> n;
        cin >> x >> y;
        status start(x, y, 20);
        for (int i = 0; i < n; i++) {
            cin >> x >> y;
            cov.insert(make_pair(x, y));
        }
        cin >> x >> y;
        pair<short, short> end = make_pair(x, y);
        cov.insert(end);

        Q.push(start);
        
        bool found = false; // 목적지에 도착했는지 확인

        while (!Q.empty()) {
            auto cur = Q.front();
            Q.pop();
            // 맥주 리필
            cur.beer_count = 20;

            // 목적지에 도착하면
            if (cur.x == end.first && cur.y == end.second) {
                cout << "happy" << '\n';
                found = true;
                break;
            }

            // 노드 순회
            for (auto it = cov.begin(); it != cov.end();) {
                int dist = abs(it->first - cur.x) + abs(it->second - cur.y); // 거리
                if (cur.beer_count * 50 >= dist) { // 다음 노드까지 주어진 맥주를 가지고 도착할 수 있으면
                    Q.push(status(it->first, it->second, cur.beer_count - ceil(dist / 50.0)));
                    it = cov.erase(it); // 방문한 노드는 제거
                } else {
                    ++it;
                }
            }
        }

        // 목적지에 도착하지 못한 경우
        if (!found) {
            cout << "sad" << '\n';
        }
    }
    return 0;
}
