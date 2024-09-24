#include <bits/stdc++.h>
using namespace std;

// 최단 경로 중에서 g-h 도로를 지난 케이스만 골라내야 함
const int INF = 1e9+10;

int main(void) {
    cin.tie(0)->sync_with_stdio(false);
    int tc; cin >> tc;
    while (tc--) {
        int n, m, t; // 교차로, 도로, 목적지 후보의 개수
        int s, g, h; // 출발지, 지나간 도로 양 끝 노드
        int gh_length;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        vector<pair<int, int>> adj[2001];
        cin >> n >> m >> t >> s >> g >> h;
        vector<int> d(n + 1, INF);
        vector<int> d2(n + 1, INF);
        vector<int> d3(n + 1, INF);
        vector<int> candicate;
        for (int i = 0; i < m; i++) {
            int a, b, d; // a와 b 사이에 길이 d의 양방향 도로
            cin >> a >> b >> d;
            adj[a].push_back({d, b});
            adj[b].push_back({d, a});
        }
        for (auto tmp : adj[g]) {
            if (tmp.second == h) gh_length = tmp.first;
        }
        // 다익스트라로 각 노드까지의 최단거리 찾기
        d[s] = 0;
        pq.push({0, s});
        while (!pq.empty()) {
            auto [cw, cv] = pq.top();
            pq.pop();
            if (d[cv] != cw) continue;
            for (auto [nw, nv] : adj[cv]) {
                if (d[cv] + nw >= d[nv]) continue;
                d[nv] = d[cv] + nw;
                pq.push({d[nv], nv});
            }
        }

        d2[h] = 0;
        pq.push({0, h});
        while (!pq.empty()) {
            auto [cw, cv] = pq.top();
            pq.pop();
            if (d2[cv] != cw) continue;
            for (auto [nw, nv] : adj[cv]) {
                if (d2[cv] + nw >= d2[nv]) continue;
                d2[nv] = d2[cv] + nw;
                pq.push({d2[nv], nv});
            }
        }

        d3[g] = 0;
        pq.push({0, g});
        while (!pq.empty()) {
            auto [cw, cv] = pq.top();
            pq.pop();
            if (d3[cv] != cw) continue;
            for (auto [nw, nv] : adj[cv]) {
                if (d3[cv] + nw >= d3[nv]) continue;
                d3[nv] = d3[cv] + nw;
                pq.push({d3[nv], nv});
            }
        }

        
        // s -> g -> h -> x의 거리 ==  d[x] 이거나
        // s -> h -> g -> x의 거리 ==  d[x] 이어야 함.
        // s -> g -> h와 s -> h -> g는 바로 알 수 있음
        // h -> x와 g -> x의 거리만 구하면 됨
        for (int i = 0; i < t; i++) {
            int x; cin >> x;
            if ((d[g] + gh_length + d2[x]) == d[x] || (d[h] + gh_length + d3[x]) == d[x]) candicate.push_back(x);
        }
        sort(candicate.begin(), candicate.end());
        for (int x : candicate) cout << x << ' ';
        cout << '\n';
    }
}