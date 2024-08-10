#include <bits/stdc++.h>
using namespace std;

// 제한된 트럭 용량으로 최대한 많은 박스들을 배송
// 조건 1: 박스를 트럭에 실으면, 이 박스는 받는 마을에서만 내린다.
// 조건 2: 트럭은 지나온 마을로 되돌아가지 않는다.
// 조건 3: 박스들 중 일부만 배송할 수도 있다.

// 도착지 기준으로 가장 가까운 노드가 탑이 되도록 pq를 구성해보자
int road[10005]; // 해당 길에서 트럭의 capa. road[1]는 1->2 
priority_queue<pair<int, int>, vector<pair<int, int>>, less<pair<int, int>>> pq[10001];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n, capa, m, result = 0; // 마을 수, 트럭 capacity, 보내는 횟수
    int s, e, w;
    cin >> n >> capa >> m;
    for (int i = 0; i < m; i++) {
        cin >> s >> e >> w;
        pq[e].push({s, w});
    }
    for (int ed = 2; ed <= n; ed++) {
        while (!pq[ed].empty()) {
            auto [st, cnt] = pq[ed].top();
            pq[ed].pop();
            int max_road = 0;
            for (int i = st; i < ed; i++) {
                if (road[i] > max_road) max_road = road[i];
            }
            int can_rcv = capa - max_road;
            if (can_rcv == 0) break;
            else if (can_rcv <= cnt) {
                for (int i = st; i < ed; i++) road[i] += can_rcv;
                result += can_rcv;
                break;
            } else {
                for (int i = st; i < ed; i++) road[i] += cnt;
                result += cnt;
            }
        }
    }
    cout << result;
}